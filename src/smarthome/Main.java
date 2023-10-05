package smarthome;

import java.util.*;
import java.util.function.Predicate;

public class SmartHome {

    private static DeviceManager deviceManager = new DeviceManager();
    private static Map<String, Schedule> schedules = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    viewDevices();
                    break;
                case 2:
                    addDevice();
                    break;
                case 3:
                    removeDevice();
                    break;
                case 4:
                    displayCommands();
                    break;
                case 5:
                    setSchedule();
                    break;
                case 6:
                    deviceStatusDetails();
                    break;
                case 7:
                    addTrigger();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. View devices");
        System.out.println("2. Add a device");
        System.out.println("3. Remove a device");
        System.out.println("4. Commands");
        System.out.println("5. Set schedule");
        System.out.println("6. Device status details");
        System.out.println("7. Automated Trigger");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void viewDevices() {
        Map<String, Device> devices = deviceManager.getDevices();
        boolean devicesFound = false;
        System.out.println("");
        System.out.println("\n===== Devices =====");
        for (Device device : devices.values()) {
            System.out.println("Device ID: " + device.getId() + ", Type: " + device.getType());
            devicesFound = true;
        }

        if (!devicesFound) {
            System.out.println("No devices found.Please Add devices");
        }
    }

    private static void addDevice() {
        System.out.print("Enter device ID: ");
        String deviceId = scanner.nextLine();

        // Check if the device already exists
        if (deviceManager.getDevice(deviceId) != null) {
            System.out.println("Device with ID " + deviceId + " already exists.");
            return;
        }

        System.out.println("Choose device type: ");
        System.out.println("1. Light");
        System.out.println("2. Thermostat");
        System.out.println("3. Door");
        System.out.print("Enter device type: ");
        int deviceTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Device device;
        switch (deviceTypeChoice) {
            case 1:
                device = new Light(deviceId);
                break;
            case 2:
                device = new Thermostat(deviceId);
                break;
            case 3:
                device = new Door(deviceId);
                break;
            default:
                System.out.println("Invalid device type choice.");
                return;
        }

        deviceManager.addDevice(device);
        System.out.println("Device added successfully.");
    }

    private static void removeDevice() {
        System.out.print("Enter the device ID to remove: ");
        String deviceId = scanner.nextLine();

        Device device = deviceManager.getDevice(deviceId);
        if (device == null) {
            System.out.println("Device with ID " + deviceId + " does not exist.");
            return;
        }

        deviceManager.removeDevice(deviceId);
        System.out.println("Device with ID " + deviceId + " removed successfully.");
        deviceStatusDetails();
    }

    private static void displayCommands() {
        System.out.println("\n===== Commands =====");
        System.out.println("1. Turn on a device");
        System.out.println("2. Turn off a device");
        System.out.println("3. Set thermostat temperature");
        System.out.println("4. Lock a door");
        System.out.println("5. Unlock a door");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the device ID: ");
        String deviceId = scanner.nextLine();
        Device device = deviceManager.getDevice(deviceId);

        if (device == null) {
            System.out.println("Device with ID " + deviceId + " does not exist.");
            return;
        }

        switch (choice) {
            case 1:
                if (device instanceof Light) {
                    ((Light) device).turnOn();
//                    System.out.println("Light turned on.");
                    deviceStatusDetails();
                } else {
                    System.out.println("This command is not applicable to the selected device.");
                }
                break;
            case 2:
                if (device instanceof Light) {
                    ((Light) device).turnOff();
                    deviceStatusDetails();
//                    System.out.println("Light turned off.");
                } else {
                    System.out.println("This command is not applicable to the selected device.");
                }
                break;
            case 3:
                if (device instanceof Thermostat) {
                    System.out.print("Enter the temperature: ");
                    int temperature = scanner.nextInt();
                    ((Thermostat) device).setTemperature(temperature);
                    deviceStatusDetails();
//                    System.out.println("Thermostat temperature set to " + temperature);
                } else {
                    System.out.println("This command is not applicable to the selected device.");
                }
                break;
            case 4:
                if (device instanceof Door) {
                    ((Door) device).lock();
                    deviceStatusDetails();
//                    System.out.println("Door locked.");
                } else {
                    System.out.println("This command is not applicable to the selected device.");
                }
                break;
            case 5:
                if (device instanceof Door) {
                    ((Door) device).unlock();
                    deviceStatusDetails();
//                    System.out.println("Door unlocked.);
                } else {
                    System.out.println("This command is not applicable to the selected device.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void setSchedule() {
        System.out.print("Enter the device ID: ");
        String deviceId = scanner.nextLine();
        Device device = deviceManager.getDevice(deviceId);

        if (device == null) {
            System.out.println("Device with ID " + deviceId + " does not exist.");
            return;
        }
        String scheduleTime;
        String scheduleData;
        if (device instanceof Light) {
            System.out.print("Enter the time for the schedule (e.g., 08:00 AM): ");
            scheduleTime = scanner.nextLine();
            System.out.print("Enter the device status (On/Off): ");
            scheduleData = scanner.nextLine();
        } else if (device instanceof Thermostat) {
            System.out.print("Enter the time for the schedule (e.g., 08:00 AM): ");
            scheduleTime = scanner.nextLine();
            System.out.print("Enter the desired temperature: ");
            scheduleData = scanner.nextLine();
        } else if (device instanceof Door) {
            System.out.print("Enter the time for the schedule (e.g., 08:00 AM): ");
            scheduleTime = scanner.nextLine();
            System.out.print("Enter the device status (Lock/Unlock): ");
            scheduleData = scanner.nextLine();
        } else {
            System.out.println("Scheduling is not applicable to the selected device.");
            return;
        }
        Schedule schedule = new Schedule(deviceId, scheduleTime, scheduleData);
        schedules.put(deviceId, schedule);
        System.out.println("Schedule set successfully.");
        System.out.println("\n===== Schedule Details =====");
        System.out.println("Device ID: " + deviceId);
        System.out.println("Device Name: " + device.getType());

        if (device instanceof Light || device instanceof Door) {
            System.out.println("Time Set: " + scheduleTime);
            System.out.println("Device Status: " + scheduleData);
        } else if (device instanceof Thermostat) {
            System.out.println("Time Set: " + scheduleTime);
            System.out.println("Desired Temperature: " + scheduleData + "F");
        } else if (device instanceof Door) {
            System.out.println("Time Set: " + scheduleTime);
            System.out.println("Device Status: " + scheduleData);
        } else {
            System.out.println("Scheduling is not applicable to the selected device.");
        }
    }

    private static void deviceStatusDetails() {
        System.out.println("\n===== Device Status Details =====");
        for (Device device : deviceManager.getDevices().values()) {
            String status;
            if (device instanceof Light) {
                status = ((Light) device).isOn() ? "On" : "Off";
            } else if (device instanceof Thermostat) {
                status = "Temperature: " + ((Thermostat) device).getTemperature();
            } else if (device instanceof Door) {
                status = ((Door) device).isLocked() ? "Locked" : "Unlocked";
            } else {
                status = "Unknown";
            }
            System.out.println("Device ID: " + device.getId() + ", Type: " + device.getType() + ", Status: " + status);
        }
    }

    private static void addTrigger() {
        System.out.print("Enter condition (e.g., temperature > 75): ");
        String condition = scanner.nextLine();
        System.out.print("Enter action (e.g., lightoff): ");
        String action = scanner.nextLine();
        System.out.print("Enter the device ID of the Light:  ");
        String deviceId = scanner.next();

        String[] conditionParts = condition.split(" ");
        if (conditionParts.length != 3) {
            System.out.println("Invalid condition format. Please use the format: 'property operator value'");
            return;
        }

        String property = conditionParts[0];
        String operator = conditionParts[1];
        int value;

        try {
            value = Integer.parseInt(conditionParts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid value. Please enter a valid numeric value.");
            return;
        }

        Predicate<Device> triggerCondition;

        switch (property) {
            case "temperature":
                triggerCondition = device -> {
                    if (device instanceof Thermostat) {
                        int temperature = ((Thermostat) device).getTemperature();
                        switch (operator) {
                            case ">":
                                return temperature > value;
                            case "<":
                                return temperature < value;
                            case "=":
                                return temperature == value;
                            default:
                                return false;
                        }
                    }
//                    else{
//                            System.out.println("The condition doesn't meets the requirment for the Trigger Action");
//                        }
                    return false;
                };
                break;
            default:
                System.out.println("Property '" + property + "' is not supported.");
                return;
        }

        for (Device device : deviceManager.getDevices().values()) {
            if (triggerCondition.test(device)) {
                switch (action) {
                    case "lighton":
                        Device device1 = deviceManager.getDevice(deviceId);
                        if (device1 instanceof Light) {
                            ((Light) device1).turnOn();
                            deviceStatusDetails();
                            return;
                        }

                    case "lightoff":
                        Device device2 = deviceManager.getDevice(deviceId);
                        if (device2 instanceof Light) {
                            ((Light) device2).turnOff();
                            deviceStatusDetails();
                        }
                    default:
                        System.out.println("Enter the Correct Action(eg: lightoff / lighton)");
                        return;
                }
            }

        }

    }
}