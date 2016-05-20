/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return process(nums,0,nums.length-1);
    }
    public TreeNode process(int[] nums, int low, int high){
        int mid;
        mid = (high+low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid==low){
            root.left=null;
        }else{
            root.left=process(nums,low,mid-1);
        }
        if(mid==high){
            root.right=null;
        }else{
            root.right=process(nums,mid+1,high);
        }
        return root;
    }
}