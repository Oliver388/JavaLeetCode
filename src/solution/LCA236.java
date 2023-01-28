package solution;

import sun.font.GlyphLayout;

/**
 * @author linglifan
 * @date 2022/09/17 20:54
 */
public class LCA236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null){
            return root;
        }
        if (left == null) return right;
        return left;
    }
}

