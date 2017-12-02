
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class FileManager {

    private File file = null;
    private BufferedReader buff_reader = null;
    private BufferedWriter buff_writer = null;
    private FileWriter fw = null;
    private FileReader fr = null;
    private ArrayList<FieldDefinition> fields = null;
    private ArrayList<Record> records = null;
    private int availList_offset = -1;
    private int offset_final = 0;
    private int recordPerLine = 0;

    public FileManager() {
        fields = new ArrayList<>();
        records  = new ArrayList<>();
    }

    //Crea un nuevo archivo con el nombre.
    public boolean newFile(String pathname, ArrayList<FieldDefinition> fields) {
        File file = new File("META" + pathname + ".txt");
        this.file = new File(pathname + ".txt");
        this.fields = fields;
        try {
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                String aux = "|";
                fw = new FileWriter(file);
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
    
    public void loadFile(String pathname) throws FileNotFoundException{
        this.file = new File(pathname+".txt");
        //Cargar metadata
        File file = new File("META"+pathname+".txt");
        fr = new FileReader(file);
        buff_reader = new BufferedReader(fr);
        if(file.exists()){
            
        }
    
    }

    public void saveFile(ArrayList<Record> records) {
        this.records = new ArrayList<>(records);
        File file = new File("META" + this.file.getName());

        try {
            //Si la availlist esta vacia
            fw = new FileWriter(this.file);
            buff_writer = new BufferedWriter(fw);
            String aux;
            aux = "";
            int offset = 0;
            if (availList_offset == -1) {
                offset = this.offset_final;
                for (int i = 0; i < records.size(); i++) {

                    aux += "|" + Integer.toString(offset);

                    for (int j = 0; j < records.get(i).getField().size(); j++) {

                        aux += ":" + records.get(i).getField().get(j);
                        offset += aux.length() - offset;

                    }
                    recordPerLine++;
                    if (recordPerLine >= 1000) {
                        System.out.println("Salto de linea");
                        buff_writer.write(aux, offset_final, aux.length() - 1);
                        buff_writer.flush();
                        recordPerLine = 0;
                        buff_writer.newLine();
                        offset++;
                    }
                }
                aux += "|";
                System.out.println(aux);
                buff_writer.write(aux, offset_final, aux.length() - 1);
                buff_writer.close();
                offset_final = offset;
                //Si la AvailList no esta vacia
            } else {

            }
            //Metada Data Init
            if (file.exists()) {

                aux = "|";
                fw = new FileWriter(file);
                buff_writer = new BufferedWriter(fw);
                for (FieldDefinition field : fields) {
                    aux += field.getName() + ":";
                    aux += field.getSize() + ":";
                    aux += field.getType() + ":";
                    aux += field.isKey() + "|";
                }

                buff_writer.write(aux);
                buff_writer.newLine();
                aux = Integer.toString(availList_offset);
                buff_writer.write(aux);

                buff_writer.newLine();
                buff_writer.write(Integer.toString(offset_final));
                buff_writer.newLine();
                buff_writer.write(Integer.toString(recordPerLine));
                buff_writer.flush();
                buff_writer.close();
                fw.close();
                //METADATA END
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
