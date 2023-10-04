package smarthome;

import java.util.HashMap;
import java.util.Map;

public class DeviceManager {
    
    private Map<String, Device> devices;

    public DeviceManager() {
        devices = new HashMap<>();
    }

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public Device getDevice(String deviceId) {
        return devices.get(deviceId);
    }

    public void removeDevice(String deviceId) {
        devices.remove(deviceId);
    }

    public Map<String, Device> getDevices() {
        return devices;
    }
}
    

