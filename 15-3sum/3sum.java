class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int j = n - 1;
            while(l < j){
                int sum = nums[i] + nums[l] + nums[j];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[j]));
                    l++;
                    j--;
                    while(l < j && nums[l] == nums[l - 1]){
                        l++;
                    }
                    while(l < j && nums[j] == nums[j + 1]){
                        j--;
                    }
                }
                else if(sum < 0){
                    l++;
                }
                else{
                    j--;
                }
            }
        }
        return ans;
    }
}