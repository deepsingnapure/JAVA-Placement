class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int absDiff = Integer.MAX_VALUE;
        int n = arr.length;

        int[][] pairs = new int[n+1][2];
        int count=0;

        List<List<Integer>>result = new ArrayList<>();
        for(int i=1;i<n;i++){
            absDiff = Math.min(absDiff,arr[i]-arr[i-1]);
        }

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1] == absDiff){
                // result.add(Arrays.asList(arr[i-1],arr[i]));
                pairs[count][0] = arr[i-1];
                pairs[count][1] = arr[i];
                count++;
            
            }
        }
        for(int i=0;i<count;i++){
            result.add(Arrays.asList(pairs[i][0],pairs[i][1]));
        }
        return result;
    }
}