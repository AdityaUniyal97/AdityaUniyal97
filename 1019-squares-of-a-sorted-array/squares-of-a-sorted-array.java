class Solution {
    public int[] sortedSquares(int[] nums) {
        Arrays.sort(nums);
        int ans[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[k] = nums[i] * nums[i];
                i++;
                k--;
            }
            else{
                ans[k] = nums[j] * nums[j];
                j--;
                k--;
            }
        }
        return ans;
    }
}