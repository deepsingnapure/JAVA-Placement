class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> personalLanguages = new HashMap<>();
        for(int i=0;i<languages.length;i++)
        {
            Set<Integer> langs = new HashSet<>();
            for(int lang : languages[i]){
                langs.add(lang);
            }
            personalLanguages.put(i+1,langs);
        }

        Set<Integer> peopleToConsider = new HashSet<>();
        for(int[] pair : friendships){
            int p1 = pair[0], p2=pair[1];
            Set<Integer>langs1 = personalLanguages.get(p1);
            Set<Integer>langs2 = personalLanguages.get(p2);

            boolean canCommunicate = false;
            for(int lang : langs1){
                if(langs2.contains(lang)){
                    canCommunicate = true;
                    break;
                }
            }
            if(!canCommunicate){
                peopleToConsider.add(p1);
                peopleToConsider.add(p2);
            }
        }
        int minans = Integer.MAX_VALUE;
        for(int lang=1;lang<=n;lang++)
        {
            int count=0;

            for(int person:peopleToConsider){
                if(!personalLanguages.get(person).contains(lang)){
                    count++;
                }
            }
            minans = Math.min(minans,count);
        }
        return minans;
    }
};