package solution;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;

/**
 * @author linglifan
 * @date 2023/01/17 20:34
 */
public class lc669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        //如果root.val > high，根据bst性质，右子树和root都在区间外，处理root.left即可
        if (root.val > high) return trimBST(root.left,low,high);
        if (root.val < low) return trimBST(root.right,low,high);
        //root在[low,high]范围内，不用处理root，直接处理左右子树即可
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
