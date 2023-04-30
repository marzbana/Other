
// Record.java
import java.io.Serializable;

public class Record implements Serializable {
    private String name;
    private String objectID;

    public Record() {
    }

    public Record(String name, String objectID) {
        this.name = name;
        this.objectID = objectID;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, objectID: %s", this.name, this.objectID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
}
