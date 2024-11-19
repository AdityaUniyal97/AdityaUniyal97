class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0; // Initialize the perimeter count
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) { // Land cell found
                    peri += 4; // Add 4 for the cell

                    // Check top neighbor
                    if (row > 0 && grid[row - 1][col] == 1) {
                        peri -= 1; // Subtract for shared top edge
                    }

                    // Check left neighbor
                    if (col > 0 && grid[row][col - 1] == 1) {
                        peri -= 1; // Subtract for shared left edge
                    }

                    // Check bottom neighbor
                    if (row < grid.length - 1 && grid[row + 1][col] == 1) {
                        peri -= 1; // Subtract for shared bottom edge
                    }

                    // Check right neighbor
                    if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
                        peri -= 1; // Subtract for shared right edge
                    }
                }
            }
        }
        
        return peri;
    }
}
