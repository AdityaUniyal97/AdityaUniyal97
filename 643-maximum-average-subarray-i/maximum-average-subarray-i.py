class Solution(object):
    def findMaxAverage(self, nums, k):
        left = 0
        maxs = float('-inf')
        wind = 0
        for right in range(len(nums)):
            wind += nums[right]
            if right - left + 1 == k:
                maxs = max(maxs , wind)
                wind -= nums[left]
                left += 1
        return maxs * 1.0/ k
        