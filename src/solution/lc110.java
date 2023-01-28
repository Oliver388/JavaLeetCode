package solution;

import com.sun.tools.corba.se.idl.toJavaPortable.Helper;

/**
 * @author linglifan
 * @date 2022/12/07 15:08
 */
public class lc110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root){
        if (root == null) return 0;
        int leftHeight = helper(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = helper(root.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }


    }

}
