import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged is empty or current interval does not overlap with the previous
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlapping intervals, merge them
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert the list to an array
        return merged.toArray(new int[merged.size()][]);
    }
}
