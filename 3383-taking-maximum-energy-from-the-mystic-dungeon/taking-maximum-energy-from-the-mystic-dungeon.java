class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] ans = new int[n];

        int res = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            ans[i] = energy[i]+(i+k<n ? ans[i+k] : 0);
            res = Math.max(res, ans[i]);
        }
        return res;
    }
}