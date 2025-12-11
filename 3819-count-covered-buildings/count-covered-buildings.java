import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
       Map<Integer,Integer> rowMin = new HashMap<>();
       Map<Integer,Integer> rowMax = new HashMap<>();
       Map<Integer,Integer> colMin = new HashMap<>();
       Map<Integer,Integer> colMax = new HashMap<>();

       for(int b[] : buildings){
        int x = b[0];
        int y = b[1];

        rowMin.put(x,Math.min(rowMin.getOrDefault(x,Integer.MAX_VALUE),y));
        rowMax.put(x,Math.max(rowMax.getOrDefault(x,Integer.MIN_VALUE),y));
        colMin.put(y,Math.min(colMin.getOrDefault(y,Integer.MAX_VALUE),x));
        colMax.put(y,Math.max(colMax.getOrDefault(y,Integer.MIN_VALUE),x));
       }
       int count = 0;
       for(int[] b : buildings){
        int x = b[0];
        int y = b[1];

        boolean hasLeft = y > rowMin.get(x);
        boolean hasRight = y < rowMax.get(x);

        boolean hasAbove = x > colMin.get(y);
        boolean hasBelow = x < colMax.get(y);
        
        if(hasLeft && hasRight && hasAbove && hasBelow){
            count++;
        }
       }
       return count;
    }
}