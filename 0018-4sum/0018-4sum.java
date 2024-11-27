import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Two-pointer logic starts here
                int low = j + 1;
                int high = n - 1;

                while (low < high) {
                    long current_sum = (long)nums[i] + nums[j] + nums[low] + nums[high];

                    if (current_sum < target) {
                        // Sum is too small, increase the lower pointer
                        low++;
                    } else if (current_sum > target) {
                        // Sum is too large, decrease the higher pointer
                        high--;
                    } else {
                        // Match found, add quadruplet to result
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));

                        // Skip duplicates for the third number
                        while (low < high && nums[low] == nums[low + 1]) low++;

                        // Skip duplicates for the fourth number
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        // Move both pointers inward
                        low++;
                        high--;
                    }
                }
            }
        }

        return result;
    }
}
