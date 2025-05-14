public class Process {
    private static int nextPid = 1;
    private final int pid;
    private final String name;
    private int memoryAllocated;

    public Process(String name) {
        this.name = name;
        this.pid = nextPid++;
        this.memoryAllocated = 0;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public void allocateMemory(int size) {
        this.memoryAllocated += size;
    }

    public int getMemoryAllocated() {
        return memoryAllocated;
    }

    @Override
    public String toString() {
        return "PID: " + pid + ", Name: " + name + ", Memory: " + memoryAllocated + "KB";
    }
}
