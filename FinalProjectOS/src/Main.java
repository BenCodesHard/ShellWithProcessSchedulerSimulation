import java.util.*;

public class Main {

    private static final Semaphore semaphore = new Semaphore(1);
    public static final MemoryManager memoryManager = new MemoryManager();
    private static final ProcessManager processManager = new ProcessManager(memoryManager);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("CLI Shell started. Type 'exit' to quit.");
        while (true) {
            System.out.print("@w3$0m3_OS> :");
            String input = scanner.nextLine().trim();
            String[] tokens = input.split("\\s+");

            if (tokens.length == 0) continue;

            switch (tokens[0].toLowerCase()) {
                case "create":
                    if (tokens.length >= 2) {

                        PCB pcb= processManager.createProcess(tokens[1]);
                        System.out.println("Process created: " + pcb.getName()+ " with PID:"+pcb.getPid());
                    } else {
                        System.out.println("Usage: create [name]");
                    }
                    break;
                case "ps":
                    processManager.listProcesses();
                    break;
                case "schedule":
                    semaphore.waitSem();
                    processManager.schedule();

                    semaphore.signal();

                    break;
                case "alloc":
                    if (tokens.length < 3) {
                        System.out.println("Usage: alloc [pid] [size]");
                        break;
                    }
                       int pid = Integer.parseInt(tokens[1]);
                       int size = Integer.parseInt(tokens[2]);
                       boolean result = memoryManager.allocate(pid, size);
                       if (result) {
                           System.out.println("Allocated process: " + pid);
                       }else {
                           System.out.println("Failed to allocate process: " + pid);
                       }
                       break;
                case "mem":
                    memoryManager.printMemory();
                    break;
                case "exit":
                    System.out.println("Exiting shell...");
                    return;
                default:
                    System.out.println("Unknown command: " + tokens[0]);
                    break;
            }
        }
    }

}
