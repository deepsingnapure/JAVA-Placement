class Solution {
    private boolean isSorted(int[] nums,int n)
    {
        for(int i=1;i<n;i++)
        {
            if(nums[i] < nums[i-1]) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        while(!isSorted(nums,n)){
            ans += 1;
            int minSum = Integer.MAX_VALUE, pos=-1;
            for(int i=1;i<n;i++){
                int sum = nums[i-1] + nums[i];
                if(sum < minSum){
                    minSum = sum;
                    pos = i;
                }
            }
            nums[pos-1] = minSum;
            for(int i=pos;i<n-1;i++){
                nums[i] = nums[i+1];
                
            }
            n--;
        }
        return ans;
    }
}