import java.util.*;

class Solution {
    static class Time {
        int arr;
        int dep;
        Time(int arr, int dep) {
            this.arr = arr;
            this.dep = dep;
        }
    }

    static int findPlatform(int arr[], int dep[]) {
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            times.add(new Time(arr[i], dep[i]));
        }

        // Sort by arrival time
        Collections.sort(times, (a, b) -> a.arr - b.arr);

        // Min heap to keep track of earliest departure
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxPlatforms = 0;

        for (Time t : times) {
            // Remove all trains that have already departed before this train arrives
            while (!pq.isEmpty() && pq.peek() < t.arr) {
                pq.poll();
            }
            // Add this train's departure time to the heap
            pq.offer(t.dep);
            maxPlatforms = Math.max(maxPlatforms, pq.size());
        }

        return maxPlatforms;
    }
}
