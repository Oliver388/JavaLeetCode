package solution;

/**
 * @author linglifan
 * @date 2023/01/14 13:44
 */
public class lc700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val > val) return searchBST(root.left,val);
        if (root.val < val) return searchBST(root.right,val);
        return null;
    }
}
