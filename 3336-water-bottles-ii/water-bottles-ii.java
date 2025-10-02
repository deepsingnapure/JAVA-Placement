class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDB = numBottles;
        int newEB = numBottles;
        while(newEB >= numExchange)
        {
            newEB -= numExchange;
            numExchange++;
            newEB++;
            totalDB++;
        }
        return totalDB;
    }
}