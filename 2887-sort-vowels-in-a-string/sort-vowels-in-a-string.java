class Solution {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();

        for(int i=0;i<s.length();i++)
        {
            if(isVowel(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        int index=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(isVowel(ch)){
                sb.append(list.get(index++));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char ch)
    {
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
}