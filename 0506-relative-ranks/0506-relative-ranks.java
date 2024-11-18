import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Step 1: Map scores to their indices
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i]; // Store score
            scoreWithIndex[i][1] = i;       // Store original index
        }

        // Step 2: Sort scores in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]); // Sort by score descending

        // Step 3: Assign ranks
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[scoreWithIndex[i][1]] = "Gold Medal"; // Highest score
            } else if (i == 1) {
                result[scoreWithIndex[i][1]] = "Silver Medal"; // Second highest score
            } else if (i == 2) {
                result[scoreWithIndex[i][1]] = "Bronze Medal"; // Third highest score
            } else {
                result[scoreWithIndex[i][1]] = String.valueOf(i + 1); // Numerical rank
            }
        }

        return result;
    }
}
