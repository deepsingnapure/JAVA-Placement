class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = 2e9;
        double high = 0;

        //calculate total area and initial bound
        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];

            //cast to double BEFORE multiplying to prevent Integer Overflow
            totalArea += l*l;

            low = Math.min(low,y);
            high = Math.max(high, y + l);

        }
        double halfArea = totalArea / 2.0;

        //binary search with fixed iterations

        for(int i=0;i<100;i++)
        {
            double mid = low + (high - low)/2.0;

            if(calculateArea(squares, mid) >= halfArea){
                high = mid;
            }else{
                low = mid;
            }
        }
        return high;
    }
    private double calculateArea(int[][] squares, double current_Y){
        double area = 0;
        for(int[] sq : squares){
            double y = sq[1];
            double l = sq[2];
            double top = y+l;

            if(y >= current_Y){
                //square is completely above the line
                continue;
            }else if(top <= current_Y){
                //square is completely below the line
                area += l*l;
            }else{
                //line cuts through the square
                //we take the width (l) * the height of bottom portion
                area += l*(current_Y - y);
            }
        }
        return area;
    }
}