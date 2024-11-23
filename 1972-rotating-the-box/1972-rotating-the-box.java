class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // Number of rows
        int n = box[0].length; // Number of columns

        // Step 1: Simulate gravity for each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // Pointer for the rightmost empty space
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') { // If it's a stone, move it to the empty position
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                } else if (box[i][j] == '*') { // If it's an obstacle, reset the empty pointer
                    empty = j - 1;
                }
            }
        }

        // Step 2: Create a transposed matrix with dimensions n x m
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - i - 1] = box[i][j]; // Transpose and reverse the rows
            }
        }

        return rotatedBox;
    }
}
