package solution;

/**
 * @author linglifan
 * @date 2023/01/16 13:08
 */
public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
