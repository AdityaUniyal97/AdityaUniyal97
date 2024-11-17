import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Initialize prefix sum array with an extra element for ease of calculation
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Initialize deque to store indices of prefixSum in increasing order
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0); // Start with index 0

        int minLength = n + 1; // Initialize minLength with a value larger than any possible subarray

        // Iterate through the prefix sum array
        for (int j = 1; j <= n; j++) {
            // Check if the current prefix sum minus the prefix sum at the front of the deque is >= k
            while (!deque.isEmpty() && prefixSum[j] - prefixSum[deque.peekFirst()] >= k) {
                // Update the minimum length if a smaller subarray is found
                minLength = Math.min(minLength, j - deque.pollFirst());
            }

            // Maintain the deque in increasing order of prefix sums
            while (!deque.isEmpty() && prefixSum[j] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(j);
        }

        // If minLength was updated, return it; otherwise, return -1
        return minLength <= n ? minLength : -1;
    }
}
