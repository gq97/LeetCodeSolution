
public class LeetCode230_KthSmallestElementInABST {
    // A better idea is to use inorder travel

    public int countNode(TreeNode root) {
        return root == null ? 0 : 1 + countNode(root.left) + countNode(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int leftCount = countNode(root.left);
        if(leftCount + 1 > k) return kthSmallest(root.left, k);
        else if(leftCount + 1 == k) {
            return root.val;
        }
        return kthSmallest(root.right, k - leftCount - 1);
    }
}
