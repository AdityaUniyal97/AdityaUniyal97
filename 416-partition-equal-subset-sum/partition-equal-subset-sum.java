import java.util.*;

class Solution {

    public boolean subset(int sum, int nums[], int n, int memo[][]) {

        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // fixed: use sum instead of w
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }

        boolean result;

        // fixed: correct condition and recursive calls
        if (nums[n - 1] <= sum) {
            result = subset(sum - nums[n - 1], nums, n - 1, memo)
                  || subset(sum, nums, n - 1, memo);
        } else {
            result = subset(sum, nums, n - 1, memo);
        }

        // store boolean as 1 / 0
        memo[n][sum] = result ? 1 : 0;
        return result;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;

        // fixed: loop boundary
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        int memo[][] = new int[n + 1][target + 1];

        // fixed: Arrays (capital A)
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // fixed: correct function call & target sum
        return subset(target, nums, n, memo);
    }
}
