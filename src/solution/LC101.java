package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author linglifan
 * @date 2022/12/07 10:16
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()){
            TreeNode first = queue.pollFirst();
            TreeNode second = queue.pollLast();
            if (first == null && second == null){
                continue;
            }
            if (first == null || second == null || first.val != second.val){
                return false;
            }
            queue.offerFirst(first.left);
            queue.offerFirst(first.right);
            queue.offerLast(second.right);
            queue.offerLast(second.left);
        }
        return true;
    }

}
