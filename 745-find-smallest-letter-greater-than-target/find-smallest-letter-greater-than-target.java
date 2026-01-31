class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        for(int i=0;i<letters.length;i++){
            if(target < letters[i]){
                ans = letters[i];
                break;
            }
            else{
                ans = letters[0];
            }
        }
        return ans;
    }
}