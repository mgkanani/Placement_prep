/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q)
            return root;
        boolean lp=find(root.left,p),lq=find(root.right,q);
        if(lp^lq){
            if(lp){//both are in left
                return lowestCommonAncestor(root.left,p,q);
            }else{//both are in right
                return lowestCommonAncestor(root.right,p,q);
            }
        }else{
            return root;
        }
    }
    public boolean find(TreeNode root, TreeNode p){
        if(root==p)
            return true;
        if(root==null)
            return false;
        return find(root.left,p) || find(root.right,p);
    }
}
/*
Lowest Common Ancestor of a Binary Tree

 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/