public class FieldDefinition {
    private String name ;
    private String type = null;
    private int size;
    private boolean key;

    public FieldDefinition(String name, String type, int size, boolean key) {
        
        this.name = name;
        this.type = type;
        this.size = size;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Tipo: " + type + ", Tamaño: " + size + ", ¿Es llave?: " + key;
    }
}
