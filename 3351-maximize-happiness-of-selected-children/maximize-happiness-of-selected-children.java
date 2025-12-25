class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness); 

        long happySum = 0;
        int count = 0;
        int n = happiness.length;

        for (int i = n - 1; i >= n - k; i--) {
            happySum += Math.max(happiness[i] - count, 0);
            count++;
        }

        return happySum;
    }
}
