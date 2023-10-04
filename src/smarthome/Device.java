package smarthome;

public class Device {

    private String id;
    private String type;

    public Device(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
