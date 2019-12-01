import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode235_LowestCommonAncestorOfABinarySearchTree {
    // Note: parameters in Java is a light-copy, like (TreeNode p), p is a quote, change p point to another one will
    // not change the call one self, but change p.val will work.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val, qVal = q.val;
        if(pVal > qVal) {
            int temp = pVal;
            pVal = qVal;
            qVal = temp;
        }
        while(root != null) {
            if(root.val >= pVal && root.val <= qVal) {
                return root;
            } else if(root.val < pVal) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        int pVal = p.val, qVal = q.val;
        if(pVal > qVal) {
            int temp = pVal;
            pVal = qVal;
            qVal = temp;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.pop();
            if(curNode.val >= pVal && curNode.val <= qVal) {
                return curNode;
            }
            if(curNode.left != null) {
                queue.add(curNode.left);
            }
            if(curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        LeetCode235_LowestCommonAncestorOfABinarySearchTree solution = new LeetCode235_LowestCommonAncestorOfABinarySearchTree();
        TreeNode ancestor = solution.lowestCommonAncestor(root, root, root.left);
        if(ancestor != null) {
            System.out.println(ancestor.val);
        }
    }
}
