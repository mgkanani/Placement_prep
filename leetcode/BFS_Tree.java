/**
 * Populating Next Right Pointers in Each Node
 *
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class BFS_Tree {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root==null)
            return ;
        TreeLinkNode temp = root;
        TreeLinkNode last=null;
        if(temp.left!=null)
            q.add(temp.left);
        if(temp.right!=null)
            q.add(temp.right);
        Queue<TreeLinkNode> q1 = null;//new Queue<TreeLinkNode>();
        while(!q.isEmpty()){
            q1 = new LinkedList<TreeLinkNode>();
            last = q.remove();
            if(last.left!=null)
                q1.add(last.left);
            if(last.right!=null)
                q1.add(last.right);
            while(!q.isEmpty()){
                temp = q.remove();
                last.next=temp;
                last=temp;
                if(temp.left!=null)
                    q1.add(temp.left);
                if(temp.right!=null)
                    q1.add(temp.right);

            }
            q=q1;
        }
    }
}