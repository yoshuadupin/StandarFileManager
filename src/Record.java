import java.util.ArrayList;

public class Record {

    private ArrayList<String> field = new ArrayList();

    public Record(int size, ArrayList<String> field) {
        this.field = field;
    }

    public ArrayList<String> getField() {
        return field;
    }

    public void setField(String content) {
        field.add(content);
    }

    public void setField(ArrayList<String> field) {
        this.field = field;
    }

}
