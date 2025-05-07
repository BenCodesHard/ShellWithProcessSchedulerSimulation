// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ProcessManager pm = new ProcessManager();
        pm.createProcess("poop");
        pm.createProcess("woop");
        pm.createProcess("doop");
        pm.listProcesses();
        pm.schedule();
        pm.listProcesses();
    }
}