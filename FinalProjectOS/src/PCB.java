public class PCB {
    private static int curPID = 0;

    private final int pid;
    private String name;
    private PCBState state;
    private boolean active;

    public PCB(String name) {
        this.pid = curPID++;
        this.name = name;
        this.state = PCBState.BLOCKED;
        this.active = false;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PCBState getState() {
        return state;
    }

    public void setState(PCBState state) {
        this.state = state;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
