    import java.util.*;
    class Solution {
        private boolean checkAnagrams(String s1, String s2){
            int[] freq = new int[26];

            for (char ch : s1.toCharArray())
                freq[ch - 'a']++;

            for (char ch : s2.toCharArray())
                freq[ch - 'a']--;

            for (int count : freq)
                if (count != 0)
                    return false;

            return true;
        }
        public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
            result.add(words[0]);
            for(int i=1;i<words.length;i++)
            {
            String last = result.get(result.size() - 1);
            if (!checkAnagrams(words[i], last)) {
                result.add(words[i]);
            }
        }
            return result;
        }
    }