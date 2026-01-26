class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int absDiff = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>>result = new ArrayList<>();
        for(int i=1;i<n;i++){
            absDiff = Math.min(absDiff,arr[i]-arr[i-1]);
        }

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1] == absDiff){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }
}