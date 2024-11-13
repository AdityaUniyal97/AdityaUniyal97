import java.util.HashMap;

public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // Edge case: if k is greater than nums.length, return 0 because a valid subarray cannot exist
        if (k > nums.length) {
            return 0;
        }
        
        long maxSum = 0;  // Maximum sum of distinct subarrays of length k
        long currentSum = 0;  // Sum of the current window
        HashMap<Integer, Integer> windowElements = new HashMap<>();  // Track elements in the current window
        int left = 0;  // Left boundary of the window

        for (int right = 0; right < nums.length; right++) {
            // Add the new element to the current window
            currentSum += nums[right];
            windowElements.put(nums[right], windowElements.getOrDefault(nums[right], 0) + 1);

            // If the window size exceeds k, shrink it from the left
            if (right - left + 1 > k) {
                currentSum -= nums[left];  // Remove the element going out of the window
                // Update the count or remove the element from windowElements
                if (windowElements.get(nums[left]) == 1) {
                    windowElements.remove(nums[left]);
                } else {
                    windowElements.put(nums[left], windowElements.get(nums[left]) - 1);
                }
                left++;
            }

            // Check if the current window has k distinct elements
            if (right - left + 1 == k && windowElements.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
