package solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author linglifan
 * @date 2022/12/06 10:37
 */
public class LC102 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0){
                TreeNode node = queue.poll();
                len--;
                if (node == null) return;
                list.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
    }
}
