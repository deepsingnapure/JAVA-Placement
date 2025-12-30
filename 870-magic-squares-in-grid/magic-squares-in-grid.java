class Solution {
    private boolean isMagicGrid(int [][]grid, int r,int c)
    {
        //unquiness (1-9) and distinc
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int num = grid[r + i][c + j];
                if(num<1 || num>9 || set.contains(num))
                {
                    return false;
                }
                else {
                    set.add(num);
                }
            }
        }
        //chech sum
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for(int i=0;i<3;i++)
        {
            if(grid[r+i][c]+grid[r+i][c+1]+grid[r+i][c+2] != sum)
                return false;
            
            if(grid[r][c+i]+grid[r+1][c+i]+grid[r+2][c+i] != sum)
                return false;

            //check digonally and anti digonalal sum
            if(grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2] != sum)
                return false;
            if(grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c] != sum)
                return false;
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0;i<=rows-3;i++)
        {
            for(int j=0;j<=cols-3;j++)
            {
                if(isMagicGrid(grid,i,j))
                {
                    count++;
                }
            }
        }
        return count;
    }
}