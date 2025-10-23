class Solution {
    public boolean hasSameDigits(String s) {
        String ans="";
        int i=0;
        while(s.length()>2 && i<s.length()-1){
            ans += (char)((((s.charAt(i)-'0')+(s.charAt(i+1)-'0'))%10)+'0');
            i++;
            if(i == s.length()-1){
                s=ans;
                i=0;
                ans="";
            }
        }
        return s.length() == 2 && s.charAt(0) == s.charAt(1);
    }
}