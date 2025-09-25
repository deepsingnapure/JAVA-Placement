class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--)
        {
            for(int j=0;j<triangle.get(i).size();j++){
                
                int next = triangle.get(i).get(j) + triangle.get(i + 1).get(j);
                int nextRight = triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1);
                
                triangle.get(i).set(j, Math.min(next, nextRight));
            }
        }
        return triangle.get(0).get(0);
    }
}