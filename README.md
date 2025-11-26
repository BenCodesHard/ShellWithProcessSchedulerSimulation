# ShellWithProcessSchedulerSimulation

A simple interactive shell written in Java that includes a basic simulation of how processes behave inside an operating system. This project was created as an educational/demo tool to illustrate process lifecycle concepts (creation, running, blocking, termination), simple scheduling behavior, and the interaction between a shell and a process scheduler.

## What this project does

- Provides a minimal shell interface implemented in Java.
- Simulates processes and a scheduler so you can experiment with:
  - Process creation and termination
  - Process states (ready, running, waiting/blocked, terminated)
  - Simple scheduling behavior and context switches
  - CPU bursts and I/O waiting (conceptual simulation; not a real OS scheduler)
- Lets you see how a shell might submit jobs to an OS scheduler and how the scheduler might manage those jobs over time.

This repository is intended for learning and demonstration rather than production use.

## Key concepts demonstrated

- Process lifecycle: how processes move between states (new → ready → running → waiting → terminated).
- Scheduling: how the scheduler selects which process to run, and how time-slicing / context switching affects behavior.
- Shell interaction: a REPL-like shell that accepts commands and uses the scheduler simulation to run jobs.

## Features (typical / expected)
- Interactive shell prompt to enter commands
- Ability to spawn simulated processes from the shell
- A scheduler that manages process execution and state transitions
- Visual or textual output showing process state changes and scheduling events

(Exact command names and simulator knobs may vary — consult the project source for the specific CLI commands implemented.)

## Requirements

- Java (JDK). The code is Java-based; a JDK is required to build and run. Java 8+ is recommended.
- Linux is required / recommended: the project appears to be designed for and tested on Linux systems and may rely on Linux-specific behavior for process/terminal interaction. Windows and macOS are not guaranteed to work without changes.

## Build & run

This project can be built and run using your preferred Java build tools or IDE. Below are general approaches:

- Using an IDE (recommended for quick exploration)
  - Import the project into IntelliJ IDEA, Eclipse, or another Java IDE and run the main class.

- Using the JDK directly (generic)
  - Compile: locate the project's `src/` folder and compile the Java files with `javac`.
    Example (from project root):
      - mkdir -p out
      - find . -name "*.java" | xargs javac -d out
  - Run: run the main class with `java -cp out <fully.qualified.MainClass>`

## Usage (general)

Start the shell, then interact with it as you would with a simple command-line program. The shell typically supports commands to:
- Spawn/run a simulated process
- List simulated processes and their states
- Inspect scheduler state
- Allocate space in memory for the process to run
- Exit the shell
Shell Syntax:
- create <ProcessName> - Creates a PCB process with the name chosen
- ps - lists all existing processes
- schedule - Schedules all ready processes and will simulate running all the processes
- alloc <pid> <size> - simulates allocating memory for a process. Every process has a unique Process ID (PID).
- mem - prints the memory that has been allocated
- exit - leave the shell


## Limitations

- Educational simulation only — this is not a real OS scheduler or process runtime.
- Linux-only (tested on Linux; other platforms may fail).
- Not hardened for production — it's intended as a learning tool.

