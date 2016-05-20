/*
 Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.left;
        if(temp!=null){
            while(temp.right!=null){temp=temp.right;}
            //flatten(root.right);
            //TreeNode right = root.right;
            temp.right=root.right;
            root.right = root.left;
            root.left=null;
            return;
        }
    }
}