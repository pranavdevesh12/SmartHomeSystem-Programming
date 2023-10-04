package smarthome;

class Schedule {

    private String deviceId;
    private String time;
    private String statusOrTemperature;

    public Schedule(String deviceId, String time, String statusOrTemperature) {
        this.deviceId = deviceId;
        this.time = time;
        this.statusOrTemperature = statusOrTemperature;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTime() {
        return time;
    }

    public String getStatusOrTemperature() {
        return statusOrTemperature;
    }
}