class Solution {
    public boolean canJump(int[] nums) {
        int f = 0;
        for(int i =0 ; i < nums.length ; i++)
        {
            if(i > f) // which will not work for the case index = 0 and f = 0
            {
                return false;
            }
            f = Math.max(f , i + nums[i]);
        }
        return true;
    }
}