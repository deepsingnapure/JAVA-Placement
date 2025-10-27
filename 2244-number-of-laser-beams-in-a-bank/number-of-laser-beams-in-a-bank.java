class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prevCount = 0;
        int result = 0;
        
        for(int i=0;i<n;i++)
        {
            int currCount = 0;
            for(char c : bank[i].toCharArray()){
                if(c == '1'){
                    currCount++;
                }
            }
            result += (currCount * prevCount);
            
            prevCount = (currCount == 0) ? prevCount : currCount;
        }
        return result;
    }
}