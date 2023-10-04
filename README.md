# SmartHomeSystem-Programming
# **_How to Execute_**

To open and run this Java project, you'll need a Java development environment and an integrated development environment (IDE) like Eclipse, IntelliJ IDEA, or Visual Studio Code. 
Run the SmartHome Class:

**Locate the SmartHome class in your IDE's project explorer:**
Right-click on the SmartHome class and select "Run" or "Debug" (the exact option may vary depending on your IDE).
This will start the program, and you should see the text-based menu in your IDE's console.

**Interact with the Program:**
Follow the on-screen instructions to interact with the program. You can add devices, set schedules, and perform various actions on the simulated smart home devices.

**Exit the Program:**
To exit the program, follow the on-screen instructions and choose the "0. Exit" option.

# About the Code:

_This Java code creates a text-based smart home management system with device classes for lights, thermostats, and doors. A DeviceManager class manages devices, and a Schedule class allows users to set actions for devices. The SmartHome class provides a menu for users to add, remove, and control devices, set schedules, and create triggers based on conditions. The code demonstrates object-oriented principles and offers a foundation for simulating a basic smart home environment through a user-friendly command-line interface._

# Modules


**Device:**

_Represents the base class for all devices.
Contains attributes id and type, and methods to get these attributes._

**Light (extends Device):**

_Represents a light device.
Includes an isOn attribute to track its state (on/off).
Provides methods turnOn() and turnOff() to control the light._

**Thermostat (extends Device):**

_Represents a thermostat device.
Contains a temperature attribute to store the desired temperature.
Provides methods to get and set the temperature._

**Door (extends Device):**

_Represents a door device.
Has an isLocked attribute to indicate if the door is locked or unlocked.
Includes methods to lock and unlock the door_.

**DeviceManager:**

_Manages a collection of devices using a Map.
Provides methods to add, remove, get, and list devices_.

**Schedule:**

_Represents a schedule for a device.
Stores deviceId, time, and statusOrTemperature attributes.
Used for scheduling actions like turning devices on/off or setting temperatures._

**SmartHome:**

_The main class that contains the program's logic.
Provides a text-based menu for user interaction and control of the smart home system.
Includes methods for viewing devices, adding devices, removing devices, setting schedules, displaying device status details, and adding triggers.
Uses a DeviceManager to manage devices and a Map called schedules to store schedules._

# Methods:

**main**_(in SmartHome):_

_The main entry point of the program.
Sets up a loop to display the menu and handle user input until the user chooses to exit.
Calls various methods based on the user's menu choice._

**printMenu() (in SmartHome):**

_Displays the menu options for the user to choose from._

**viewDevices() (in SmartHome):**

_Lists all devices in the smart home system._

**addDevice() (in SmartHome):**

_Prompts the user to add a new device, specifying its ID and type.
Creates a new device object based on the user's choice (Light, Thermostat, or Door).
Adds the device to the DeviceManager._

**removeDevice() (in SmartHome):**

_Prompts the user to enter the ID of a device they want to remove.
Removes the device from the DeviceManager._

**displayCommands() (in SmartHome):**

_Displays a submenu for controlling devices, such as turning lights on/off or setting thermostat temperatures.
Executes the selected command based on user input._

**setSchedule() (in SmartHome):**

_Allows the user to schedule actions for a specific device (e.g., turn on/off a light at a specified time).
Creates a Schedule object and stores it in the schedules map._

**deviceStatusDetails() (in SmartHome):**

_Displays detailed information about the status of all devices in the smart home system._

**addTrigger() (in SmartHome):**

_Allows the user to create triggers based on conditions and actions.
Parses user input for conditions and actions, then evaluates and performs actions on devices based on conditions._

# MindMap for SmartHome Program

- Main Menu
  - View Devices
  - Add Device
  - Remove Device
  - Display Commands
  - Set Schedule
  - Device Status Details
  - Add Trigger
  - Exit Program

- Components
  - DeviceManager
    - addDevice()
    - getDevice()
    - removeDevice()
    - getDevices()
  - Device
    - id
    - type
    - getId()
    - getType()
  - Light
    - isOn
    - isOn()
    - turnOn()
    - turnOff()
  - Thermostat
    - temperature
    - getTemperature()
    - setTemperature()
  - Door
    - isLocked
    - isLocked()
    - lock()
    - unlock()
  - Schedule
    - deviceId
    - time
    - statusOrTemperature

- User Interactions
  - Main Menu Options
  - Input Device Info
  - Input Device ID
  - Input Schedule Time
  - Input Status/Temperature
  - Input Condition
  - Input Action
  - Input Device ID for Trigger

- Actions
  - Displaying Device List
  - Adding a Device
  - Removing a Device
  - Displaying Commands
  - Setting a Schedule
  - Displaying Device Status
  - Adding a Trigger
  - Exiting the Program

- Program Flow
  - User selects options from the Main Menu
  - Actions are performed based on the selected option
  - Device information is managed by DeviceManager
  - Devices have unique IDs and types
  - Devices have specific actions and attributes
  - Schedules can be set for devices
  - Triggers can perform actions based on conditions
