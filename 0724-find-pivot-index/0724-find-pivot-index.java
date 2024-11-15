class Solution {
    public int pivotIndex(int[] nums) {
        // calculate the total sum of the array
        int totalSum = 0;
        for(int num : nums)
        {
            totalSum += num;
        }

        // Initialise the left Sum
        int leftSum = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            // Calculate the right Sum
            int rightSum = totalSum - leftSum - nums[i];

            // Check if left and right are same
            if(leftSum == rightSum)
            {
                return i;
            }

            // Update the left for the next iteration
            leftSum += nums[i];
        }
        return -1;
    }
}