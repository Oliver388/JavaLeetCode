package solution;

import javax.naming.InsufficientResourcesException;
import java.util.TooManyListenersException;

/**
 * @author linglifan
 * @date 2022/09/19 15:17
 */
public class diameterTree543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        count(root);
        return max;
    }

    public int count(TreeNode root){
        if (root == null) return 0;
        int leftHeight = count(root.left);
        int rightHeight = count(root.right);
        max = Math.max(leftHeight + rightHeight,max);
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
