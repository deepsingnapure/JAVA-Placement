class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        final int M = 1_000_000_007;

        List<Integer> hList = new ArrayList<>();
        for(int x:hFences) hList.add(x);
        hList.add(1);
        hList.add(m);

        List<Integer> vList = new ArrayList<>();
        for(int x:vFences) vList.add(x);
        vList.add(1);
        vList.add(n);

        Collections.sort(hList);
        Collections.sort(vList);

        Set<Integer> widths = new HashSet<>();

        for(int i=0;i<vList.size();i++){
            for(int j=i+1;j<vList.size();j++){
            int width = vList.get(j)-vList.get(i);
            widths.add(width);
         }
        }
        int maxSide = 0;
        for(int i=0;i<hList.size();i++){
            for(int j=i+1;j<hList.size();j++){
            int height = hList.get(j)-hList.get(i);
            if(widths.contains(height)){
                maxSide = Math.max(maxSide,height);
            }
        }
        }
        return maxSide == 0 ? -1 : (int) ((1L * maxSide * maxSide) % M);
    }

}