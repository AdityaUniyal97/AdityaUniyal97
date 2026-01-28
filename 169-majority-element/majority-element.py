class Solution(object):
    def majorityElement(self, nums):
        candi = nums[0]
        count = 1
        for i in range(1,len(nums)):
            if nums[i] == candi:
                count += 1
            else:
                count -= 1
            if count == 0:
                candi = nums[i]
                count = 1
        return candi    
        