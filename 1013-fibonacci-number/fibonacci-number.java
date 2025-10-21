class Solution {
    //main
    public int fib(int n) {
       if(n == 0 || n == 1){
        return n;
       }
       int dp[] = new int[n + 1];
       return helper(n , dp);
    }
    //helper 
    public int helper(int n , int dp[]){
        if (n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int f1 = helper(n-1 , dp);
        int f2 = helper(n-2 , dp);
        int result = f1 + f2;
        dp[n] = result;
        return result;
    }
}