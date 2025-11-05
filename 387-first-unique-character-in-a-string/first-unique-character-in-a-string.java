class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            if(arr[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}