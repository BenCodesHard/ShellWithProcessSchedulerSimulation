import java.util.*;

public class Main {
    private static final List<Process> processList = new ArrayList<>();
    private static final Semaphore semaphore = new Semaphore(1);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("CLI Shell started. Type 'exit' to quit.");
        while (true) {
            System.out.print("@w3$0m3_OS> :");
            String input = scanner.nextLine().trim();
            String[] tokens = input.split("\\s+");

            if (tokens.length == 0) continue;

            switch (tokens[0].toLowerCase()) {
                case "create":
                    if (tokens.length >= 2) {
                        createProcess(tokens[1]);
                    } else {
                        System.out.println("Usage: create [name]");
                    }
                    break;
                case "ps":
                    listProcesses();
                    break;
                case "schedule":
                    schedule();
                    break;
                case "alloc":
                    if (tokens.length == 3) {
                        try {
                            int pid = Integer.parseInt(tokens[1]);
                            int size = Integer.parseInt(tokens[2]);
                            allocateMemory(pid, size);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid PID or size format.");
                        }
                    } else {
                        System.out.println("Usage: alloc [pid] [size]");
                    }
                    break;
                case "mem":
                    showMemory();
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

    private static void createProcess(String name) {
        Process p = new Process(name);
        processList.add(p);
        System.out.println("Process created: " + p);
    }

    private static void listProcesses() {
        if (processList.isEmpty()) {
            System.out.println("No processes found.");
        } else {
            for (Process p : processList) {
                System.out.println(p);
            }
        }
    }

    private static void schedule() {
        try {
            System.out.println("Acquiring CPU (waitSem)...");
            semaphore.waitSem();
            System.out.println("CPU acquired.");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    private static void allocateMemory(int pid, int size) {
        for (Process p : processList) {
            if (p.getPid() == pid) {
                p.allocateMemory(size);
                System.out.println("Allocated " + size + "KB to PID " + pid);
                return;
            }
        }
        System.out.println("Process with PID " + pid + " not found.");
    }

    private static void showMemory() {
        for (Process p : processList) {
            System.out.println("PID " + p.getPid() + ": " + p.getMemoryAllocated() + "KB");
        }
    }
}
