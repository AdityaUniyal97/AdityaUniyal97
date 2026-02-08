class Solution(object):
    def threeSumClosest(self, nums, target):
        nums.sort()
        n = len(nums)
        close = nums[0] + nums[1] + nums[2]
        for i in range(n - 2):
            l = i + 1
            r = n - 1
            while l < r:
                curr = nums[i] + nums[l] + nums[r]
                if abs(curr - target) < abs(close - target):
                    close = curr
                if curr < target:
                    l += 1
                elif curr > target:
                    r -= 1
                else:
                    return curr
        return close