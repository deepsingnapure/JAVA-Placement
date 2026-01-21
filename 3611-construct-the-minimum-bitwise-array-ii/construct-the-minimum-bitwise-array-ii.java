class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);

            if(val % 2 == 0){
                result[i] = -1;
            }else{
                long t = (long) val + 1;

                long lowbit = t & -t;

                result[i] = val -(int)(lowbit >> 1);
            }
        }
        return result;
    }
}
