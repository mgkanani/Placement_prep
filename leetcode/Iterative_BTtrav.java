/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

Iterative solution of binary tree traversal.
 */
import java.util.*;
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s1= new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        TreeNode t1,t2,cur=root;
        do{
            if(cur!=null){
                s1.push(cur);
                cur=cur.left;
                continue;
            }
            cur=s1.pop();
            list.add(cur.val);
            cur=cur.right;
        }while(!s1.isEmpty() || cur!=null);
        return list;
    }
}
