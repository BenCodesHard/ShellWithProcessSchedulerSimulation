public enum PCBState {
    //PCB is ready to get running, able to be scheduled
    READY,
    //PCB is actively running, using the CPU
    RUNNING,
    //Something is stopping this PCB from being ready!
    BLOCKED;
}
