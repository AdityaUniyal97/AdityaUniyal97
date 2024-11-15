class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Edge case: Empty needle
        }

        int[] lps = computeLPS(needle); // Step 1: Build LPS table
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle

        // Step 2: Search using the LPS table
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                // Characters match, move both pointers
                i++;
                j++;
                if (j == needle.length()) {
                    // Found the needle in the haystack
                    return i - j;
                }
            } else {
                if (j > 0) {
                    // Mismatch after some matches, jump using LPS
                    j = lps[j - 1];
                } else {
                    // Mismatch at the beginning, move haystack pointer
                    i++;
                }
            }
        }

        return -1; // Needle not found
    }

    // Helper function to compute the LPS table
    private int[] computeLPS(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        int length = 0; // Tracks the length of the current prefix-suffix
        int i = 1; // Start comparing from the second character

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length > 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
