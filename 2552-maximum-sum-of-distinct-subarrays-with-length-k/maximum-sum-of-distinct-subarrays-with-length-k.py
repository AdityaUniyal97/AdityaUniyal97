class Solution(object):
    def maximumSubarraySum(self, nums, k):
        s = set()
        l = 0
        curr_sum = 0
        ans = 0
        for r in range(len(nums)):
            while nums[r] in s:
                s.remove(nums[l])
                curr_sum -= nums[l]
                l += 1
            
            s.add(nums[r])
            curr_sum += nums[r]

            if r - l + 1 == k:
                ans = max(ans,curr_sum)
                s.remove(nums[l])
                curr_sum -= nums[l]
                l+=1
        return ans