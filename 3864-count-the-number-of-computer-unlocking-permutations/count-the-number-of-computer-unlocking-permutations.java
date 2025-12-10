class Solution {
    public int countPermutations(int[] complexity) {
        long MOD = 1_000_000_007;
        int n = complexity.length;
        int rootComplexity = complexity[0];

        for(int i=1;i<n;i++){
            if(complexity[i] <= rootComplexity)
                return 0;
        }

        long fact = 1;
        for(int i=1;i<n;i++){
            fact = (fact*i)%MOD;
        }
        return (int)fact;
    }
}