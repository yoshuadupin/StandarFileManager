
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
public class Record {

    private ArrayList<String> field;

    public Record(int size , ArrayList<String> field) {
        this.field = new ArrayList<>(size);
        this.field = field;
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
