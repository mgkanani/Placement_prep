/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
public class BTPostTrav {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root==null)
            return list;
        st.push(root);
        TreeNode temp;
        while(!st.isEmpty()){
            temp = st.pop();
            list.add(0,temp.val);
            if(temp.left!=null)
                st.push(temp.left);
            if(temp.right!=null)
                st.push(temp.right);
        }
        return list;
    }
}