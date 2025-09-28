class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        for(int i=n;i>=2;i--)
        {
            if(nums[i-1]+nums[i-2]>nums[i])
            {
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        return 0;
    }
}