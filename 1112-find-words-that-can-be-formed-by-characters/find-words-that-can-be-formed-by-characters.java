class Solution {
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        for(String word : words){
            if(canFormWord(word,chars)){
                len += word.length();
            }
        }
        return len;
    }

    private boolean canFormWord(String word, String chars){
        int[] charCount = new int[26];

        for(char ch : chars.toCharArray()){
            charCount[ch-'a']++;
        }
        for(char ch : word.toCharArray()){
            if(charCount[ch-'a'] == 0){
                return false;
            }
            charCount[ch-'a']--;
        }
        return true;
    }
}