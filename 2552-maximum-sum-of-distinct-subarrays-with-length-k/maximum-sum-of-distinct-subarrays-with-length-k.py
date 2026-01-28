class Solution(object):
    def maximumSubarraySum(self, nums, k):
        s = 0
        ans = 0
        w = 0
        freq = {}

        for e in range(len(nums)):
            w += nums[e]
            freq[nums[e]] = freq.get(nums[e],0) + 1

            if e - s + 1 == k:
                if len(freq) == k:
                    ans = max(ans,w)
                
                freq[nums[s]] -= 1
                if freq[nums[s]] == 0:
                    del freq[nums[s]]
                
                w -= nums[s]
                s += 1
        return ans
        