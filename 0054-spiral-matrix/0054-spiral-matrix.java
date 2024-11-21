class Solution {
    List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    
    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;
    
    while (top <= bottom && left <= right) {
        // Traverse from left to right across the top row
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;  // Move the top boundary down
        
        // Traverse from top to bottom down the right column
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;  // Move the right boundary left
        
        if (top <= bottom) {
            // Traverse from right to left across the bottom row
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;  // Move the bottom boundary up
        }
        
        if (left <= right) {
            // Traverse from bottom to top up the left column
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;  // Move the left boundary right
        }
    }
    
    return result;
}

}