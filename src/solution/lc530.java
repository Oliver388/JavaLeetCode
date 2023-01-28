package solution;

import java.util.ArrayDeque;
import java.util.Stack;
import java.util.regex.MatchResult;

/**
 * @author linglifan
 * @date 2023/01/14 19:49
 */
public class lc530 {
//    int result = Integer.MAX_VALUE;
//    TreeNode pre;
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return 0;
//        helper(root);
//        return result;
//    }
//
//    public void helper(TreeNode root){
//        if (root == null) return;
//        helper(root.left);
//        if (pre!= null){
//            result = Math.min(result,root.val- pre.val);
//        }
//        pre = root;
//        helper(root.right);
//    }
    public int getMinimumDifference(TreeNode root){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null){
                result = Math.min(result,root.val-pre.val);
            }
            pre = root;
            root = root.right;

        }
        return result;
    }
}
