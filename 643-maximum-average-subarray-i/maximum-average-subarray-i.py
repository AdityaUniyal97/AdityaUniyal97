class Solution(object):
    def findMaxAverage(self, nums, k):
            s = 0
            w = 0
            max_sum = float('-inf')

            for e in range(len(nums)):
                    w += nums[e]
                    if e - s + 1 == k:
                        max_sum = max(max_sum , w)
                    
                        w -= nums[s]
                        s += 1
            return max_sum / float(k)
        