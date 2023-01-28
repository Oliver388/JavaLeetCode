package solution;

/**
 * @author linglifan
 * @date 2022/12/07 11:05
 */
public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}
