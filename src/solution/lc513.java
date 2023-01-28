package solution;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author linglifan
 * @date 2022/12/09 13:50
 */
public class lc513 {
    public int findBottomLeftValue(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i<size;i++){
                TreeNode poll = queue.poll();
                if (i == 0){
                    result = poll.val;
                }

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return result;
    }
}
