class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length, res = 0;
        int[] rem = new int[value];
        for(int x:nums){
            int r=((x%value)+value) % value;
            rem[r]++;
        }
        //int res = 0;
        while (true) {
            int r = res % value;
            if (rem[r] == 0) break;  // found missing remainder
            rem[r]--;  // use one occurrence
            res++;
        }
        return res;
    }
}