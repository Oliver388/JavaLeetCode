package solution;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author linglifan
 * @date 2022/12/06 11:01
 */
public class LC226 {
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode rightTree = root.right;
//        root.right = invertTree(root.left);
//        root.left = invertTree(rightTree);
//        return root;
//    }

    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                size--;
                TreeNode rightTree = node.right;
                node.right = node.left;
                node.left = rightTree;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
