class Solution {
    public int countPalindromicSubsequence(String s) {
        int totalPalindromes = 0;
        
        // 1. Iterate through every letter from 'a' to 'z'
        // These are the "Outer Shells" (e.g., 't' ... 't')
        for (char c = 'a'; c <= 'z'; c++) {
            
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            
            // 2. We need valid positions with space in between
            if (first != -1 && last > first + 1) {
                
                // 3. Use a boolean array to track unique characters seen in the middle
                boolean[] seen = new boolean[26];
                int uniqueCount = 0;
                
                // Iterate STRICTLY between first and last index
                for (int i = first + 1; i < last; i++) {
                    int charIndex = s.charAt(i) - 'a';
                    
                    // If we haven't seen this character in this segment yet...
                    if (!seen[charIndex]) {
                        seen[charIndex] = true; // Mark as seen
                        uniqueCount++;          // Count it
                        
                        // Optimization: If we found all 26 chars, stop early for this letter
                        if (uniqueCount == 26) break; 
                    }
                }
                
                totalPalindromes += uniqueCount;
            }
        }
        
        return totalPalindromes;
    }
}