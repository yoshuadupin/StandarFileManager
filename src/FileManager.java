
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class FileManager {

    //Archivo que se maneja actualmente
    private File file = null;
    //Variables Buffers    
    private BufferedReader buff_reader = null;
    private BufferedWriter buff_writer = null;
    //Variables File para llamar al buffer
    private FileWriter fw = null;
    private FileReader fr = null;
    //Arreglo de la definicion de campos
    private ArrayList<FieldDefinition> fields = null;
    //
    private LinkedList<Record> records = null;
    //2da Linea
    private int availList_offset = -1;
    // 3ra linea
    private int offset_final = 0;
    //4ta linea
    private int recordPerLine = 0;

    public FileManager() {
        fields = new ArrayList<>();
        records = new LinkedList<>();
    }

    //Crea un nuevo archivo con el nombre.
    public boolean newFile(String pathname, ArrayList<FieldDefinition> fields) {
        File metaFile = new File("META_" + pathname + ".txt");
        this.file = new File(pathname);
        File indexFile = new File("INDEX_" + pathname);

        this.fields = fields;
        try {

            if (metaFile.exists()) {
                metaFile.delete();

            }
            //METADATA
            if (metaFile.createNewFile()) {
                indexFile.createNewFile();
                String aux = "|";
                fw = new FileWriter(metaFile);
                buff_writer = new BufferedWriter(fw);
                for (FieldDefinition field : fields) {
                    aux += field.getName() + ":";
                    aux += field.getSize() + ":";
                    aux += field.getType() + ":";
                    aux += field.isKey() + "|";
                }
                //Escribe metadata para campos
                buff_writer.write(aux);
                buff_writer.newLine();
                //Escribe metadata para AvailList
                aux = Integer.toString(availList_offset);
                buff_writer.write(aux);
                //Escribe metadata para buscar el final de archivo y hacer  append
                buff_writer.newLine();
                offset_final = 0;
                recordPerLine = offset_final;
                buff_writer.write(Integer.toString(offset_final));
                buff_writer.newLine();
                buff_writer.write(Integer.toString(recordPerLine));
                buff_writer.flush();
                buff_writer.close();

                return true;

            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void closeFile() {
        file = null;
        buff_reader = null;
        buff_writer = null;
        fw = null;
        fr = null;
        fields = null;
        records = null;
        availList_offset = -1;
        offset_final = 0;
        recordPerLine = 0;
        System.gc();
    }

    public void loadFile(String pathname) throws FileNotFoundException, IOException {
        //Cargar metadata
        //File file = new File("META"+pathname+".txt");

        if (file.exists()) {
            System.out.println("HIZO CARGAR");
            this.file = new File(pathname);
            File metaFile = new File("META_" + pathname + ".txt");
            //Cargar FileDefinitions
            fr = new FileReader(metaFile);
            buff_reader = new BufferedReader(fr);
            String stringField = buff_reader.readLine();
            // System.out.println(stringField);
            fields = new ArrayList<>();
            StringTokenizer tokenField = new StringTokenizer(stringField, "|", false);
            while (tokenField.hasMoreTokens()) {
                StringTokenizer tokenVar = new StringTokenizer(tokenField.nextToken(), ":", false);
                while (tokenVar.hasMoreTokens()) {
                    String name = tokenVar.nextToken();
                    int size = Integer.parseInt(tokenVar.nextToken());
                    String type = tokenVar.nextToken();
                    boolean key;
                    if (tokenVar.nextToken().equals("true")) {
                        key = true;
                    } else {
                        key = false;
                    }
                    fields.add(new FieldDefinition(name, type, size, key));

                }
            }
            this.availList_offset = Integer.parseInt(buff_reader.readLine());
            this.offset_final = Integer.parseInt(buff_reader.readLine());
            this.recordPerLine = Integer.parseInt(buff_reader.readLine());

            buff_reader.close();
        }

    }

    public void reestructurFile(ArrayList<FieldDefinition> newFields) throws FileNotFoundException, IOException {
        RandomAccessFile randFile = new RandomAccessFile(file, "rw");
        RandomAccessFile indexFile = new RandomAccessFile("INDEX_" + this.file.getName(), "rw");
        //Maximo de Buff
        byte[] buffRead = new byte[(int) randFile.length()];
        int cantRecord = buffRead.length / sizeBuff(fields);
        int byteSize = cantRecord * sizeBuff(newFields);
        byte[] buffWrite = new byte[byteSize];
        System.out.println(byteSize);
        System.out.println((int) randFile.length());
        //Moverse en el BuffWrite
        int moveBW = -1;
        //MOverse el BR
        int moveBR = -1;
        randFile.readFully(buffRead);
        int cont = 0;

        try {
            for (int i = 0; cont < cantRecord * newFields.size(); i++) {
                System.out.println("CICLO QUE TRUENA");
                System.out.println(cont);
                if (fields.size() == i) {
                    i = 0;
                }
                cont += 1;

                //Si el tipo cambia o cambia el tamano
                //System.out.println(moveBW);
                if (!fields.get(i).equals(newFields.get(i))) {
                    if (!fields.get(i).getType().equals(newFields.get(i).getType())) {
                        //Conversion de tipo y la informacion se pierde
                        //Convierte a Char
                        if (newFields.get(i).getType().equals("CHAR")) {

                            //El numero de caracteres UNICODE y 4 bytes
                            //Guardara un valor por defecto 
                            String aux = "";
                            for (int j = 0; j < newFields.get(i).getSize(); j++) {
                                aux += "*";
                            }
                            byte[] temp = stringToByte(aux);
                            //Copiar en el buffWrite
                            for (int j = 0; j < temp.length; j++) {
                                moveBW++;
                                buffWrite[moveBW] = temp[j];

                            }
                            //Convierta INT
                        } else if (newFields.get(i).getType().equals("INT")) {
                            //VALOR POR DEFECTO
                            byte[] temp = toByteArray(0);
                            for (int j = 0; j < temp.length; j++) {
                                moveBW++;
                                buffWrite[moveBW] = temp[j];

                            }
                            //Convierte a Float    
                        } else if (newFields.get(i).getType().equals("FLOAT")) {
                            byte[] temp = float2ByteArray((float) 0.0);
                            for (int j = 0; j < temp.length; j++) {
                                moveBW++;
                                buffWrite[moveBW] = temp[j];

                            }
                        }
                        //Para moverse el BuffReader
                        if (fields.get(i).getType().equals("CHAR")) {
                            moveBR += fields.get(i).getSize();
                        } else if (fields.get(i).getType().equals("INT")) {
                            moveBR += 4;
                        } else if (fields.get(i).getType().equals("FLOAT")) {
                            moveBR += 4;
                        }
                        //!!!!TERMINA CONVERSION DE TIPO//////
                    } else {
                        //Si cambia solo el tamano
                        if (newFields.get(i).getType().equals("CHAR")) {

                            if (newFields.get(i).getSize() < fields.get(i).getSize()) {
                                for (int j = 0; j < newFields.get(i).getSize(); j++) {
                                    moveBW++;
                                    moveBR++;
                                    buffWrite[moveBW] = buffRead[moveBR];

                                }
                                moveBR+=fields.get(i).getSize()-newFields.get(i).getSize();

                            } else {
                                //Hay que rellenar el espacio 
                                System.out.println("Cambia tamano");
                                String aux = "";
                                for (int j = 0; j < newFields.get(i).getSize() - fields.get(i).getSize(); j++) {
                                    aux += "*";
                                }
                                System.out.println(aux);
                                byte[] temp = stringToByte(aux);
                                System.out.println(temp.length);
                                System.out.println(fields.get(i).getSize());
                                //Copiar en el buffWrite
                                for (int j = 0; j < fields.get(i).getSize(); j++) {
                                    moveBW++;
                                    moveBR++;
                                    buffWrite[moveBW] = buffRead[moveBR];

                                }
                                for (int j = 0; j < temp.length; j++) {
                                    moveBW++;
                                    buffWrite[moveBW] = temp[j];

                                }
                                moveBR += fields.get(i).getSize();

                            }

                        } else if (newFields.get(i).getType().equals("INT")) {
                            //VALOR POR DEFECTO
                            byte[] temp = toByteArray(0);
                            for (int j = 0; j < temp.length; j++) {
                                moveBW++;
                                buffWrite[moveBW] = temp[j];
                            }
                            moveBR += 4;
                        } else if (newFields.get(i).getType().equals("FLOAT")) {
                            byte[] temp = float2ByteArray((float) 0.0);
                            for (int j = 0; j < temp.length; j++) {
                                moveBW++;
                                buffWrite[moveBW] = temp[j];
                            }
                            moveBR += 4;
                        }
                        //Se mueve en el BR;

                    }

                } else {
                    //Si son iguales solo copiara la informacion
                    if (newFields.get(i).getType().equals("CHAR")) {
                        for (int j = 0; j < newFields.get(i).getSize(); j++) {
                            moveBW++;
                            moveBR++;
                            buffWrite[moveBW] = buffRead[moveBR];
                        }
                    } else if (newFields.get(i).getType().equals("INT")) {
                        for (int j = 0; j < 4; j++) {
                            moveBW++;
                            moveBR++;
                            buffWrite[moveBW] = buffRead[moveBR];
                        }
                    } else if (newFields.get(i).getType().equals("FLOAT")) {
                        for (int j = 0; j < 4; j++) {
                            moveBW++;
                            moveBR++;
                            buffWrite[moveBW] = buffRead[moveBR];
                        }
                    }
                }
                
                //REINDEXAR
                indexFile.seek(0);
                for (int j = 0; j < byteSize;) {
                    byte[] keyB = {buffWrite[j] ,buffWrite[j++] ,buffWrite[j++] ,buffWrite[j++]};
                    indexFile.write(keyB);
                    indexFile.writeLong(indexFile.length());
                    j+=sizeBuff(newFields)-3;
                }
                randFile.seek(0);
                randFile.write(buffWrite);
                randFile.setLength(byteSize);
                
                //if(){}
            }
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Errores");
            System.out.println("MOVEBW");
            System.out.println(moveBW);
            System.out.println("MOVEBR");
            System.out.println(moveBR);
            System.out.println("TAMANOS");
            System.out.println("SIZE BW:" + buffWrite.length);
            System.out.println("SIZE BR:" + buffRead.length);
        }
        randFile.close();
        indexFile.close();
    }

    public void saveFile(ArrayList<Record> records) throws FileNotFoundException {
        this.records = new LinkedList<>(records);
        File metafile = new File("META_" + this.file.getName() + ".txt");
        RandomAccessFile randFile = new RandomAccessFile(file, "rw");
        RandomAccessFile indexFile = new RandomAccessFile("INDEX_" + this.file.getName(), "rw");

        try {
            //Hara append
            if (availList_offset != -1) {

            } else {
                String aux1 = "|";
                fw = new FileWriter(metafile);
                buff_writer = new BufferedWriter(fw);
                //Character por linea 2^12;
                for (FieldDefinition field : fields) {
                    aux1 += field.getName() + ":";
                    aux1 += field.getSize() + ":";
                    aux1 += field.getType() + ":";
                    aux1 += field.isKey() + "|";
                }
                //Escribe metadata para campos
                buff_writer.write(aux1);
                buff_writer.newLine();
                //Escribe metadata para AvailList
                aux1 = Integer.toString(availList_offset);
                buff_writer.write(aux1);
                //Escribe metadata para buscar el final de archivo y hacer  append
                buff_writer.newLine();
                offset_final = 0;
                recordPerLine = offset_final;
                buff_writer.write(Integer.toString(offset_final));
                buff_writer.newLine();
                buff_writer.write(Integer.toString(recordPerLine));
                buff_writer.flush();
                buff_writer.close();

                randFile.seek(randFile.length());
                indexFile.seek(indexFile.length());
                System.out.println(fields.size());
                int cantReg = 6000 / sizeBuff(fields);
                int lengthBuff = cantReg * sizeBuff(fields);
                int offsetBuff = records.size() * sizeBuff(fields);
                byte[] buff = new byte[offsetBuff];
                int cont = 0;
                //GUARDA AL FINAL DEL ARCHIVO
                for (int i = 0; i < records.size(); i++) {
                    for (int j = 0; j < records.get(i).getField().size(); j++) {
                        if (fields.get(j).isKey()) {
                            //Escribe Llave
                            System.out.println("PALABRA: " + records.get(i).getField().get(j));
                            indexFile.writeInt(Integer.parseInt(records.get(i).getField().get(j)));
                            //Escribe RRN
                            //USA 8 bytes en vez de 4
                            indexFile.writeLong(indexFile.length());

                        }
                        if (fields.get(j).getType().equals("CHAR")) {
                            //El numero de caracteres UNICODE y 4 bytes
                            String aux = records.get(i).getField().get(j);
                            int size = aux.length();
                            for (int k = 0; k < fields.get(j).getSize() - size; k++) {
                                aux += "*";
                            }

                            byte[] temp = stringToByte(aux);

                            for (int k = 0; k < temp.length; k++) {
                                buff[cont] = temp[k];
                                cont++;
                            }
                        } else if (fields.get(j).getType().equals("INT")) {
                            byte[] temp = toByteArray(new Integer(records.get(i).getField().get(j)));
                            for (int k = 0; k < temp.length; k++) {
                                buff[cont] = temp[k];
                                cont++;
                            }
                        } else if (fields.get(j).getType().equals("FLOAT")) {
                            byte[] temp = float2ByteArray(new Float(records.get(i).getField().get(j)));
                            for (int k = 0; k < temp.length; k++) {
                                buff[cont] = temp[k];
                                cont++;
                            }
                        }
                    }
                }
                //INDEXA AL ARCHIVO INDICE
                randFile.write(buff, 0, offsetBuff);
                randFile.close();
                indexFile.close();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public String convertToken(Record record) {
        String aux = "";
        String patron = "";
        //COntruir patron 
        System.out.println(fields.size());
        patron += "|";
        for (int i = 0; i < fields.size(); i++) {

            patron += record.getField().get(i);
            for (int j = 0; j < fields.get(i).getSize() - record.getField().get(i).length(); j++) {
                patron += "*";
            }
            patron += "|";
        }
        return patron;
    }

    public int sizeBuff(ArrayList<FieldDefinition> fields) {
        int size = 0;

        System.out.println(fields.size());
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getType().equals("CHAR")) {
                //El numero de caracteres UNICODE y 4 bytes
                size += fields.get(i).getSize();
            } else if (fields.get(i).getType().equals("INT")) {
                size += 4;
            } else if (fields.get(i).getType().equals("FLOAT")) {
                size += 4;
            }
        }
        
        System.out.println("HOLA " + size);
        return size;
    }

    public static byte[] float2ByteArray(float value) {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static float convertToFloat(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getFloat();

    }

    public int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    public byte[] toByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public byte[] stringToByte(String str1) {
        byte[] by_new = str1.getBytes();
        return by_new;
    }

    public String byteToString(byte[] by) throws UnsupportedEncodingException {
        String str1 = new String(by, "UTF-8");
        return str1;
    }

}
