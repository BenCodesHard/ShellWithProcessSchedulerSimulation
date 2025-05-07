public class PCB {
    private int pid;
    private String name;
    private PCBState state;
    private boolean active;

    public PCB(int pid, String name, PCBState state, boolean active) {
        this.pid = pid;
        this.name = name;
        this.state = state;
        this.active = active;
    }
}
