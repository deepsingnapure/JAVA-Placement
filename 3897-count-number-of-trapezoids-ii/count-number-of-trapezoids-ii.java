import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        // t: grouped by normalized slope (sx, sy)
        // v: grouped by exact direction vector (dx, dy)
        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();

        int n = points.length;

        // Process all point pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                // Compute direction vector
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                // Normalize direction to ensure consistent representation
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                
                // Reduce to simplest form using GCD
                int g = gcd(dx, Math.abs(dy));
                int sx = dx / g;  // normalized x component
                int sy = dy / g;  // normalized y component
                
                // Compute line equation constant: sx*y - sy*x
                int des = sx * points[i][1] - sy * points[i][0];
                
                // Create keys for hashmaps
                // Key packing: (sx << 12) | (sy + 2000)
                // 12 bits allow sx up to 4095, offset ensures positive index
                int key1 = (sx << 12) | (sy + 2000);  // for normalized slope
                int key2 = (dx << 12) | (dy + 2000);  // for exact vector
                
                // Store in both maps
                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }

        // Final calculation
        return count(t) - count(v) / 2;
    }

    // Count total segment pairs in all groups
    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
        long ans = 0;
        
        for (HashMap<Integer, Integer> inner : map.values()) {
            long sum = 0;
            
            // Count total segments in this slope group
            for (int val : inner.values()) sum += val;
            
            // Count valid pairs: sum(val * (sum - val)) for each line
            for (int val : inner.values()) {
                sum -= val;
                ans += (long) val * sum;
            }
        }
        
        return (int) ans;
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}