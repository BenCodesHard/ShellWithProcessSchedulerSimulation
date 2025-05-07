import java.util.ArrayList;
import java.util.List;

public class ProcessManager {
    private List<PCB> processList = new ArrayList<>();
    public void createProcess(String name) {
        PCB process = new PCB(name);
    }

    /**
     * prints each READY process as RUNNING (simulating round robin)
     */
    public void schedule(){

    }
    //Make a process to sleep for a while to simulate its running time, such as 5 seconds

    /**
     * display all processes and their states
     */
    public void listProcesses(){

    }
}
