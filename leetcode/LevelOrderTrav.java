import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class LevelOrderTrav {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2;// = new ArrayList<TreeNode>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(root.val);
        ret.add(l1);
        if(root.left!=null) 
            list1.add(root.left);
        if(root.right!=null) 
            list1.add(root.right);
        TreeNode temp;
        while(!list1.isEmpty()){
            list2 = new ArrayList<TreeNode>();
            l1 = new ArrayList<Integer>();
            while(!list1.isEmpty()){
                temp = list1.remove(0);
                l1.add(temp.val);
                if(temp.left!=null) 
                    list2.add(temp.left);
                if(temp.right!=null) 
                    list2.add(temp.right);
            }
            list1=list2;
            if(!l1.isEmpty())
                ret.add(l1);
        }
        return ret;
    }
}
