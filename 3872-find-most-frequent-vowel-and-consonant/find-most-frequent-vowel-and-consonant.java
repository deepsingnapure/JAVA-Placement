class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVow=0, maxCon=0;
        for(char c : s.toCharArray())
        {
            int index = c - 'a';
            freq[index]++;
            if(c == 'a' ||c=='e'|| c=='i'||c=='o'||c=='u'){
                maxVow = Math.max(maxVow,freq[index]);
            }else{
            maxCon = Math.max(maxCon,freq[index]);
        }
        }
        return maxVow+maxCon;
    }
}