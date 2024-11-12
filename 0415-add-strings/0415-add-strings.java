class Solution {
    public String addStrings(String num1, String num2) {
        // Use StringBuilder for result since we are building a string output
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1;
            int digit2;

            // Get the digit from num1 if i is valid, else use 0
            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';  // Corrected to subtract '0' for character to integer
            } else {
                digit1 = 0;
            }

            // Get the digit from num2 if j is valid, else use 0
            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';  // Subtracting '0' to convert character to integer
            } else {
                digit2 = 0;
            }

            // Calculate the sum of the two digits plus any carry from the previous iteration
            int total = digit1 + digit2 + carry;

            // Add the last digit of 'total' to the result (total % 10)
            result.append(total % 10);

            // Update carry for the next iteration (total / 10)
            carry = total / 10;

            // Move to the next digits on the left
            i = i - 1;
            j = j - 1;
        }

        // Since we added digits from right to left, reverse the result to get the final sum
        return result.reverse().toString();
    }
}
