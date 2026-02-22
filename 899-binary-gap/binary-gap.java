class Solution {
    public int binaryGap(int n) {
        int largDist = 0;
        int currDist = 0;
        boolean found = false;

        while(n > 0){
            int bit = n%2;

            if(bit == 1){
                if(found){
                    largDist = Math.max(currDist,largDist);
                }
                currDist = 1;
                found = true;
            }
            else{
                if(found){
                    currDist++;
                }
            }
            n /= 2;
        }

        return largDist;
    }
}