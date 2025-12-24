class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int box=0;
        int m=capacity.length-1;
        int sum=0;
        for(int s:apple){
            sum+=s;

        }
        while(m>=0){
            sum -= capacity[m];
            box++;
            if(sum<=0) break;
            m--;
        }
        return box;
    }
}