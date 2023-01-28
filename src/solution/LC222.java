package solution;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.*;

/**
 * @author linglifan
 * @date 2022/12/07 12:01
 */
public class LC222 {

    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                size--;
                result++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
        }
        return result;
    }


}
