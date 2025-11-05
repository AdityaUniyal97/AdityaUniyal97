class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=  0;
        double ml = 0;
        double sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum += nums[i];
        }

        ml = sum;
        for(int i = k ; i < nums.length ; i++){
            sum += nums[i] - nums[i - k];
            ml = Math.max(sum , ml);
        }
        return ml / k;
    }
}