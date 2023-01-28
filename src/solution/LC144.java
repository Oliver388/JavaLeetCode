package solution;

import com.sun.xml.internal.bind.util.Which;

import java.util.*;

/**
 * @author linglifan
 * @date 2022/12/06 10:14
 */
public class LC144 {

//    List<Integer> list;
//    public List<Integer> preorderTraversal(TreeNode root) {
//        list = new ArrayList<>();
//        return helper(root,list);
//    }
//
//    private List<Integer> helper(TreeNode root,List<Integer> list){
//        if (root == null) return Collections.emptyList();
//        list.add(root.val);
//        helper(root.left,list);
//        helper(root.right,list);
//        return list;
//
//    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }
}
