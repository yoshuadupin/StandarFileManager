import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileManager file = new FileManager();
        ArrayList<FieldDefinition> fields = new ArrayList<>();
        ArrayList<Record> records = new ArrayList<>();
        ArrayList<String> field = new ArrayList<>();
        String aux1 = "Ciudad";
        String aux3 = "Nombre";
        String aux4 = "Apellido";
        String aux5 = "Carrera";
        Integer integer = new Integer(5);

        fields.add(new FieldDefinition(aux1, "char", 20, true));
        fields.add(new FieldDefinition("Edad", "int", 20, false));
        fields.add(new FieldDefinition(aux3, "char", 20, false));
        fields.add(new FieldDefinition(aux4, "char", 20, false));
        fields.add(new FieldDefinition(aux5, "char", 20, false));

        field.add(aux1);
        field.add("15");
        field.add(aux3);
        field.add(aux4);
        field.add(aux5);
        System.out.println(field);
        for (int i = 0; i < 100; i++) {
            records.add(new Record(5, field));
        }

        if (file.newFile("Archivo", fields)) {
            System.out.println("Escribio en el archivo");
            file.saveFile(records);
            file.loadFile("Archivo");
        }
    }

}
