class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        long sum = 0;
        long maxy = 0;
        for(int right = 0 ; right < nums.length ; right++){
            map.put(nums[right], map.getOrDefault(nums[right],0) + 1);
            sum+= nums[right];

            while(map.get(nums[right]) > 1){
                map.put(nums[left] , map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }

            while(right - left + 1 > k){
                map.put(nums[left] , map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }

            if(right - left + 1 == k){
                maxy = Math.max(maxy , sum);
            }
        }
        return maxy;
    }
}