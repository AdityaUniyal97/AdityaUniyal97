class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Handle edge case where array is empty

        int index = 1; // Start from 1 since the first element is always unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
