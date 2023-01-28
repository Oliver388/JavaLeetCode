package solution;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import sun.lwawt.LWKeyboardFocusManagerPeer;

/**
 * @author linglifan
 * @date 2023/01/16 12:44
 */
public class lc236 {
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
