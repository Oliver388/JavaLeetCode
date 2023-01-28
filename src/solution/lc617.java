package solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author linglifan
 * @date 2023/01/03 14:32
 */
public class lc617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if (root2 == null) return root1;
        if (root1 == null) return root2;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
