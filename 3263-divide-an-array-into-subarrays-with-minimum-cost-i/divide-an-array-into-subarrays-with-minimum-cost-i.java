class Solution {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums,1,nums.length);
        
        int minSum = nums[0];

        return minSum + nums[1] + nums[2];
        
    }
}