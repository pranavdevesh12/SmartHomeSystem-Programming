package smarthome;


public class  Thermostat extends Device {

    private int temperature;

    public Thermostat(String id) {
        super(id, "Thermostat");
        this.temperature = 100; // Default temperature
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}