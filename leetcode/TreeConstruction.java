/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeConstruction {
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre.length==0)
            return null;
        return build(pre, 0 , pre.length-1,in , 0, in.length-1);
    }
    TreeNode build(int[] pre, int i1, int j1, int []in, int i2,int j2){
        if(i1>j1 || i2>j2)
            return null;
        if(i2==j2)
            return new TreeNode(pre[i1]);
        else{
            TreeNode root = new TreeNode(pre[i1]);
            int i=0,m1=0,m2=0;
            for(i=i2;i<=j2;i++){
                if(in[i]==pre[i1])
                    break;
            }
            m2=i;
            if(pre[i1]==in[i2]){
                root.left = null;
                m1=i1;
            }else{
               root.left = build(pre,i1+1,i1+(m2-i2),in,i2,m2-1); 
            }
            root.right = build(pre,i1+(m2-i2)+1,j1,in,m2+1,j2);
            return root;
        }
    }
}

/*
Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.

You may assume that duplicates do not exist in the tree. 
*/