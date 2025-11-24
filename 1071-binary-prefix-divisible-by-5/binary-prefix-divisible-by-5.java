class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for(int num : nums)
        {
            sum = (sum * 2 + num) % 5;
            result.add(sum == 0);
        }
        return result;
    }
}