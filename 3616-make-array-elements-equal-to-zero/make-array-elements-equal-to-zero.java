class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0, left=0,right=0,curr=0;
        for(int num:nums) ans  += num;

        for(int num : nums)
        {
             right = ans - left - num;
            if(num == 0){
                if(left==right){
                    curr+=2;
                }
                else if(left==right-1 || left-1==right){
                    curr +=1;
                }
            }
            left += num;
        }
        return curr;
    }
}