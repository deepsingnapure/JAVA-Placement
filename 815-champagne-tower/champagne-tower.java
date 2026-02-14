class Solution {

    double[][] t = new double[101][101];

    private double solve(int poured, int i, int j) {

        if (i < 0 || j < 0 || j > i) {
            return 0.0;
        }

        if (i == 0 && j == 0) {
            return poured;
        }

        if (t[i][j] != -1.0) {
            return t[i][j];
        }

        double upLeft  = (solve(poured, i - 1, j - 1) - 1.0) / 2.0;
        double upRight = (solve(poured, i - 1, j) - 1.0) / 2.0;

        if (upLeft < 0)  upLeft = 0.0;
        if (upRight < 0) upRight = 0.0;

        return t[i][j] = upLeft + upRight;
    }

    public double champagneTower(int poured, int query_row, int query_glass) {

        // initialize memo table
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                t[i][j] = -1.0;
            }
        }

        return Math.min(1.0, solve(poured, query_row, query_glass));
    }
}