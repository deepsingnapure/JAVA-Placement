class Solution {

    private int findSumDivisor(int num)
    {
        int divisors = 0;
        int sum = 0;
        for(int fact=1; fact*fact <= num; fact++)
        {
            int other = num/fact;
            if(num%fact == 0)
            {
                if(other == fact){
                divisors += 1;
                sum += fact;
                }
                else{
                    divisors += 2;
                    sum += (fact+other);
                }
            }
            if(divisors > 4) return 0;
        }
        return divisors == 4 ? sum : 0;

    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int num : nums)
        {
            result += findSumDivisor(num);
        }
        return result;
    }
}