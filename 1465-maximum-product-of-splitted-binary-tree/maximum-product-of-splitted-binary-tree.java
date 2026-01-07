/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long maxP = 0;
    public long sum = 0;
    static final int MOD = 1_000_000_007;
    
    private int findTotalSum(TreeNode root){
        if(root == null)
            return 0;
        
        long leftSubTreeSum = findTotalSum(root.left);
        long rightSubTreeSum = findTotalSum(root.right);
        long sum = root.val + leftSubTreeSum + rightSubTreeSum; 

        return (int)sum;
    }

    private int find(TreeNode root)
    {
        if(root == null)
            return 0;

        long leftSum = find(root.left);
        long rightSum = find(root.right);
        long subSumTree = root.val + leftSum + rightSum;

        long remainSubTreeSum = sum - subSumTree;

        maxP = Math.max(maxP ,subSumTree*remainSubTreeSum );

        return (int)subSumTree;
    }

    public int maxProduct(TreeNode root) {
        if(root == null)
            return 0;
        
        maxP = 0;
        sum = findTotalSum(root);
        find(root);

        return (int)(maxP % MOD);
    }
}