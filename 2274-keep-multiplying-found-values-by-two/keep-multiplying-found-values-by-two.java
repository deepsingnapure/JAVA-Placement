class Solution {
    public int findFinalValue(int[] nums, int original) {
        int res = original;
        Set <Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
            
        }
        while(set.contains(res)){
            
            res = res * 2;
            
        }
        return res;
    }
}