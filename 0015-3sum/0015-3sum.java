import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array
        
        // Step 2: Iterate through the array, fixing one element at a time
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicate elements for 'i'

            int left = i + 1;  // Two-pointer setup
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {  // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers to look for new pairs
                    left++;
                    right--;
                    
                    // Skip duplicates for 'left' and 'right'
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;  // Increase sum by moving 'left' rightward
                } else {
                    right--;  // Decrease sum by moving 'right' leftward
                }
            }
        }
        
        return result;
    }
}
