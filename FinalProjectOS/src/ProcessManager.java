import java.util.ArrayList;
import java.util.List;

public class ProcessManager {
    private List<PCB> processList = new ArrayList<>();

    /**
     * creates a PCB and adds it to the processList
     * @param name
     */
    public void createProcess(String name) {
        PCB process = new PCB(name);
        processList.add(process);

    }

    /**
     * prints each READY process as RUNNING (simulating FCFS scheduling)
     */
    public void schedule(){
        for(PCB process : processList){
            if(process.isActive() && process.getState() == PCBState.READY){
                System.out.println("Process " + process.getPid() + " is in READY state");
                process.setState(PCBState.RUNNING);
                System.out.println("Process " + process.getPid() + " is now in RUNNING state");

                try {
                    Thread.sleep(5000); // Simulate 5 seconds of running time
                } catch (InterruptedException e) {
                    System.out.println("Process interrupted");
                }

                process.setState(PCBState.READY);
            }
        }
    }
    //Make a process to sleep for a while to simulate its running time, such as 5 seconds

    /**
     * display all processes and their states
     */
    public void listProcesses(){
        for (PCB process : processList) {
            System.out.println("Process " + process.getPid() + " is in " + process.getState() + " state");
        }
    }
}
