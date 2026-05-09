import java.util.*;

class Solution {

    static class Pair {
        int diff;
        int idx;

        Pair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }
    }

    static int maxProfit(int x, int y, int[] a, int[] b) {

        int n = a.length;

        Pair[] arr = new Pair[n];

        // Store difference and index
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(Math.abs(a[i] - b[i]), i);
        }

        // Sort by descending difference
        Arrays.sort(arr, (p1, p2) -> p2.diff - p1.diff);

        int profit = 0;

        for (int i = 0; i < n; i++) {

            int idx = arr[i].idx;

            // Prefer Machine A
            if ((a[idx] >= b[idx] && x > 0) || y == 0) {
                profit += a[idx];
                x--;
            }

            // Otherwise Machine B
            else {
                profit += b[idx];
                y--;
            }
        }

        return profit;
    }
}