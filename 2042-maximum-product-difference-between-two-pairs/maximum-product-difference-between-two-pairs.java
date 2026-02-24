class Solution {
    public int maxProductDifference(int[] nums) {

        int n = nums.length;
        int firstLargest = Integer.MIN_VALUE, secondLargest = firstLargest;
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = firstSmallest;

        for(int num : nums){
            if(num > firstLargest){
                secondLargest = firstLargest;
                firstLargest = num;
            }
            else{
                secondLargest = Math.max(secondLargest,num);
            } 
            
            if(num < firstSmallest){
                secondSmallest = firstSmallest;
                firstSmallest = num;
            }else{
                secondSmallest = Math.min(secondSmallest,num);
            } 
        }
        return (firstLargest * secondLargest) - (secondSmallest*firstSmallest);
    }
}