class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        // processing times p[i][j] = skill[i] * mana[j]
        long[][] p = new long[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                p[i][j] = (long) skill[i] * mana[j];

        // prevComp[i] = completion time of previous potion on wizard i
        long[] prevComp = new long[n];

        for (int j = 0; j < m; ++j) {
            long S;              // start time of current potion on wizard 0
            if (j == 0) {
                S = 0;
            } else {
                // find smallest S such that for every wizard i:
                // S + sum_{q=0..i-1} p[q][j] >= prevComp[i]
                // i.e. S >= prevComp[i] - prefix_i
                long prefix = 0;
                S = Long.MIN_VALUE;
                for (int i = 0; i < n; ++i) {
                    long candidate = prevComp[i] - prefix;
                    if (candidate > S) S = candidate;
                    prefix += p[i][j];
                }
                if (S < 0) S = 0; // start can't be negative
            }

            // compute completion times for this potion on all wizards
            long[] currComp = new long[n];
            long cum = 0;
            for (int i = 0; i < n; ++i) {
                cum += p[i][j];          // cum = sum_{q=0..i} p[q][j]
                currComp[i] = S + cum;   // completion on wizard i
            }
            prevComp = currComp;
        }

        // completion time of last potion on last wizard
        return prevComp[n - 1];
    }
}
