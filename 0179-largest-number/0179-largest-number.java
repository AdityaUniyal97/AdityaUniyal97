public class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert integers to strings for concatenation comparisons
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Step 2: Use a two-pointer approach to sort the array based on custom logic
        for (int i = 0; i < strNums.length; i++) {
            for (int j = i + 1; j < strNums.length; j++) {
                // Compare concatenations in two possible orders
                String order1 = strNums[i] + strNums[j]; // Example: "3" + "30" = "330"
                String order2 = strNums[j] + strNums[i]; // Example: "30" + "3" = "303"

                // If order2 is larger, swap the two strings to make the largest combination
                if (order2.compareTo(order1) > 0) {
                    String temp = strNums[i];
                    strNums[i] = strNums[j];
                    strNums[j] = temp;
                }
            }
        }

        // Step 3: Concatenate sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String str : strNums) {
            result.append(str);
        }

        // Step 4: Handle edge case where all numbers are zero
        if (result.charAt(0) == '0') {
            return "0";
        }

        // Return the final largest number as a string
        return result.toString();
    }
}
