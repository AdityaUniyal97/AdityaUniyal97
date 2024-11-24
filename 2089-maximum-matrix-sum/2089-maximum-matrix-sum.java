class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ts = 0;
        int nc = 0;
        int sm = Integer.MAX_VALUE;

        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                // Add absolute vlaue to the Sum
                int value = matrix[i][j];

                ts += Math.abs(value);
                // count the negative numbers
                if(value < 0)
                {
                    nc++;
                }
                // Update the smallest negative numbers
                sm = Math.min(sm , Math.abs(value));
            }
        }
        if(nc % 2 != 0)
        {
            ts -= 2 * sm;
        }
        return ts;
    }
}