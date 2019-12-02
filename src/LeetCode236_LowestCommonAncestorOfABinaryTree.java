import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode236_LowestCommonAncestorOfABinaryTree {
    // Another solution may consider storing the parent node of each node
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int idx = 0;
        TreeNode curNode = root;
        while(!stack.isEmpty() || curNode != null) {
            while(curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            map.put(curNode.val, idx++);
            curNode = curNode.right;
        }
        curNode = root;
        int pVal = map.get(p.val), qVal = map.get(q.val);
        while(curNode != null) {
            int cVal = map.get(curNode.val);
            if(cVal < pVal && cVal < qVal) {
                curNode = curNode.right;
            } else if(cVal > pVal && cVal > qVal) {
                curNode = curNode.left;
            } else {
                return curNode;
            }
        }
        return null;
    }
}