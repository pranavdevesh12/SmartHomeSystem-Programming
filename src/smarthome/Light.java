package smarthome;



public class Light extends Device {

    private boolean isOn;

    public Light(String id) {
        super(id, "Light");
        this.isOn = false; // Light is initially off
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
}
