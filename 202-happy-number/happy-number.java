class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = helper(slow);
            fast = helper(helper(fast));
        }while(slow != fast);
        return slow == 1;
    }

    private int helper(int n){
        int res = 0;
        while(n > 0){
            int ld = n % 10;
            res += ld * ld;
            n = n / 10;
        }
        return res;
    }
}