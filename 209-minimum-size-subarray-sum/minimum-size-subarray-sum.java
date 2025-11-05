class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ml = Integer.MAX_VALUE;
        int low = 0;
        for(int high =- 0 ; high < nums.length ; high++){
            sum += nums[high];
            while(sum >= target){
                int len = high - low + 1;
                ml = Math.min(ml , len);
                sum -= nums[low];
                low++;
            }
        }
        return (ml == Integer.MAX_VALUE) ? 0 : ml;
    }
}