class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int close = nums[0] + nums[1] + nums[2];
        // setp 2 outer loop to fix nums[i]
        for(int i = 0 ; i < n -2 ; i ++)
        {
            int left = i + 1;
            int right = n - 1;
            while(left < right)
            {
                int cur = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - cur) < Math.abs(target - close))
                {
                    close = cur;
                }
                if(cur < target)
                {
                    left++;
                }
                else if(cur > target)
                {
                    right -- ;
                }else{
                    return cur;
                }
            }
        }
        return close;
    }
}