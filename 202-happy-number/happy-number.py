class Solution:
    def isHappy(self, n: int) -> bool:
        slow = n
        fast = n
        while(True):
            slow = self.nextL(slow)
            fast = self.nextL(self.nextL(fast))
            if slow == fast:
                break
        return slow == 1
    
    def nextL(self,n):
        sum = 0
        while n > 0:
            ld = n % 10
            sum += ld * ld
            n //= 10
        return sum