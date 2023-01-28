package solution;

/**
 * @author linglifan
 * @date 2022/12/09 13:19
 */
public class LC404 {
    int count = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return  0;
        helper(root);
        return count;
    }

    private void helper(TreeNode root){
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null){
            count = count + root.left.val;
        }
    }
}
