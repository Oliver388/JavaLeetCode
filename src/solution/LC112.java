package solution;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.annotation.Resource;

/**
 * @author linglifan
 * @date 2022/12/09 14:51
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }

    private boolean dfs(TreeNode root, int count){
        if (root == null) return false;
        count -= root.val;
        if (root.left == null && root.right == null) {
            return count == 0;
        }

        if (root.left != null){
            boolean left = dfs(root.left, count);
            if (left) return true;
        }

        if (root.right != null){
            boolean right = dfs(root.right, count);
            if (right) return true;
        }

        return false;

    }
}
