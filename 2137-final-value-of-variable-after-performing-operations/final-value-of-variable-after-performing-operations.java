class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int op=0; op<operations.length;op++)
        {
            if(operations[op].charAt(0)=='+'||operations[op].charAt(2)=='+')            x++;
            else x--;
        }
        return x;
    }
}