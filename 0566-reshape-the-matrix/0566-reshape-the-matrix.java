class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
     int m = mat.length; // Number of rows
     int n = mat[0].length;
     if(m * n != r * c)
     {
        return mat; // Return original matrix if reshaping isnt allowed
     }   
     int[][] reshaped = new int[r][c];
     for(int i =0 ; i < m * n ; i++)
     {
        reshaped[i / c][i % c] = mat[i / n][i % n];
     }
     return reshaped;
    }
}