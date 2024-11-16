class Solution {
    public int[] resultsArray(int[] nums, int k) {
        // Edge case: If k is greter than the array length , return an empty array which is -1
        if(k > nums.length)
        {
            return new int[0];
        }

        // Initialise the result array
        int[] result = new int[nums.length - k + 1];

        // Iterate through k slides
        for(int i = 0 ; i <= nums.length - k ; i++)
        {
            boolean isConse = true;

            // Check if the current subarray is consecutive
            for(int j = i + 1 ; j < i + k ; j++)
            {
                if(nums[j] != nums[j - 1] + 1)
                {
                    isConse = false;
                    break;
                }
            }

            // If consecutive  , set the last element of the subarray as the result
            if(isConse)
            {
                result[i] = nums[i + k - 1];
            }
            else{
                result[i] = -1;
            }
        }
        return result;
    }
}