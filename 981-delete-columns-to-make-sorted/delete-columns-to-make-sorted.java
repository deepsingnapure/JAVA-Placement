class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int DeletedCount = 0;

        for(int c=0;c<col;c++){
            for(int r=1;r<row;r++){
                if(strs[r].charAt(c)<strs[r-1].charAt(c)){
                    DeletedCount++;
                    break;
                }
            }
        }
        return DeletedCount;
    }
}