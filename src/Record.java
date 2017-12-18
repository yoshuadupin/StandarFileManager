import java.util.ArrayList;

public class Record {

    private ArrayList<String> fields = new ArrayList();

    public Record(int size, ArrayList<String> fields) {
        this.fields = fields;
    }

    public ArrayList<String> getFields() {
        return fields;
    }

    public void setField(String content) {
        fields.add(content);
    }

    public void setFields(ArrayList<String> fields) {
        this.fields = fields;
    }

}
