class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);

        int maxPair = 0;
        int left = 0, right = nums.length-1;

        while(left < right){
            int pairSum = nums[left] + nums[right];
            if(pairSum > maxPair){
                maxPair = pairSum;

            }
            left++;
            right--;
        }
        return maxPair;
    }
}