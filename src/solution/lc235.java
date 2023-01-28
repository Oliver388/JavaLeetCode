package solution;

/**
 * @author linglifan
 * @date 2023/01/16 12:57
 */
public class lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root.val > q.val && root.val > p.val){
            return lowestCommonAncestor(root.left,q,p);
        }
        if (root.val < q.val && root.val < p.val){
            return lowestCommonAncestor(root.right,q,p);
        }
        return root;
    }
}
