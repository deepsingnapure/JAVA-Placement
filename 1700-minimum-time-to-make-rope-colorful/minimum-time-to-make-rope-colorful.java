class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0,j=0;
        int totalTime=0;
        int n=colors.length();

        while(i<n && j<n)
        {
            int maxTime = 0, currTotal=0;
            while(j<n && colors.charAt(i)==colors.charAt(j))
            {
                maxTime=Math.max(maxTime,neededTime[j]);
                currTotal += neededTime[j];
                j++;
            }
            i=j;
            totalTime += (currTotal-maxTime);
        }
        return totalTime;
    }
}