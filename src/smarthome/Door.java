package smarthome;

public class  Door extends Device {

    private boolean isLocked;

    public Door(String id) {
        super(id, "Door");
        this.isLocked = true; // Door is initially locked
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }
}