/*
okay so bassically what we have to do we have given the upper and lower limit and a array with some elements we have to find the elements from the given array whose sum is less than the upper and greter than lowe
*/
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int left = 0; left < nums.length; left++) {
            int lowIndex = findLowerBound(nums, left + 1, nums.length - 1, lower - nums[left]);
            int highIndex = findUpperBound(nums, left + 1, nums.length - 1, upper - nums[left]);
            count += highIndex - lowIndex + 1;
        }

        return count;
    }

    private int findLowerBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    private int findUpperBound(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}