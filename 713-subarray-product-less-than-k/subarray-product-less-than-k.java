class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int l = 0;
        int prod = 1;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            prod *= nums[i];

            while(prod >= k){
                prod /= nums[l];
                l++;
            }

            count += (i - l + 1);
        }
        return count;
    }
}