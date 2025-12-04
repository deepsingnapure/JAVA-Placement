class Solution {
    public int countCollisions(String directions) {
        int n = directions.length(); // Fix: use .length() for String

        // 1. Skip all 'L' cars at the very start
        // These drive off to the left and hit nothing.
        int i = 0;
        while (i < n && directions.charAt(i) == 'L') { // Fix: use .charAt()
            i++;
        }

        // 2. Skip all 'R' cars at the very end
        // These drive off to the right and hit nothing.
        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        // 3. Count everything in the middle
        // Any car in this "sandwich" zone that is NOT 'S' will eventually crash.
        int collision = 0;
        while (i <= j) {
            if (directions.charAt(i) != 'S') {
                collision++;
            }
            i++;
        }
        
        return collision;
    }
}