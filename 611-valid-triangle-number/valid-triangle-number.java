class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int triplet = 0;
        int n = nums.length;
        for(int k=n-1;k>=2;k--)
        {
            int i=0,j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    triplet += j-i;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
       
        return triplet;
    }
}