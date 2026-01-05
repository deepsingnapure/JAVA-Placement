class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;

        long sum = 0;
        int countNegative = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum += Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0)
                {
                    countNegative++;
                }

                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, Math.abs(matrix[i][j]));
            }
        }
        if(countNegative % 2 == 0)//even number of negative
        {
            return sum;
        }
        return sum - 2 * smallestAbsoluteValue;
    }
}