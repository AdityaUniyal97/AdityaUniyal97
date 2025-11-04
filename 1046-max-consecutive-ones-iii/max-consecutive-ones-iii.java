class Solution {
    public int longestOnes(int[] nums, int k) {
       int low = 0;
       int zero = 0;
       int res = 0;
       for(int right = 0 ; right < nums.length ;right++){
           if(nums[right] == 0){
            zero++;
           }
           while(zero > k){
             if(nums[low] == 0){
                zero--;
             }
             low++;
           }

           res = Math.max(res , right - low + 1);
       } 
       return res;
    }
}