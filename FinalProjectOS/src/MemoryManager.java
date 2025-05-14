import java.util.*;

public class MemoryManager {
    private static final int TOTAL_MEMORY = 4096;
    private Map<Integer, int[]> allocations = new HashMap<>();

    /**
     * space is allocated by marking the start and end points of memory on the spectrum of 4096 which is the max memory
     * free blocks of memory are found by finding the difference between an end point and the next start point
     * free blocks are sorted in order to find the smallest block possible for the size of the process which makes this best-fit
     * @param pid process id
     * @param size process size
     * @return true if successful, if there is no space false will be returned
     */
    public boolean allocate(int pid, int size) {
        if (size > TOTAL_MEMORY || allocations.containsKey(pid)) return false;
        List<int[]> blocks = new ArrayList<>(allocations.values());
        blocks.sort(Comparator.comparingInt(a -> a[0]));

        int bestStart = -1;
        int bestSize = Integer.MAX_VALUE;
        int previousEnd = 0;

        for (int[] block : blocks) {
            int start = block[0];
            int gapSize = start - previousEnd;
            if (gapSize >= size && gapSize < bestSize) {
                bestStart = previousEnd;
                bestSize = gapSize;
            }
            previousEnd = block[1];
        }
        int finalGapSize = TOTAL_MEMORY - previousEnd;
        if (finalGapSize >= size && finalGapSize < bestSize) {
            bestStart = previousEnd;
            bestSize = finalGapSize;
        }
        if (bestStart == -1) return false;
        allocations.put(pid, new int[]{bestStart, bestStart + size});
        return true;
    }

    /**
     * uses the pid to find the block location on the map, and then it removes it to free the space
     * @param pid process id
     */
    public void free(int pid) {
        if (allocations.containsKey(pid)) {
            allocations.remove(pid);
        } else {
            System.out.println("process id not found");
        }
    }

    /**
     * should display the start and end locations of each process
     */
    public void printMemory() {
        for (Map.Entry<Integer, int[]> entry : allocations.entrySet()) {
            System.out.println("PID " + entry.getKey() + ": Start=" + entry.getValue()[0] + " End=" + entry.getValue()[1]);
        }
    }
}
