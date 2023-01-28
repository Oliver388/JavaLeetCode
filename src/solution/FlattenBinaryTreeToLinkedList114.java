package solution;


import sun.tools.tree.OrExpression;

import java.util.LinkedList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.Stack;

/**
 * @author linglifan
 * @date 2022/09/01 19:25
 */
public class FlattenBinaryTreeToLinkedList114 {

    /**
     * 把原来的左子树放在右子树，将原来的右子树挂在新的右子树之后
     * @param root
     */
//    public void flatten(TreeNode root) {
//        if (root == null){
//            return;
//        }
//        flatten(root.left);
//        flatten(root.right);
//
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        //吧原来的左子树放在右子树
//        root.left = null;
//        root.right = left;
//
//        TreeNode p = root;
//        while (p.right!=null){
//            p=p.right;
//        }
//        p.right = right;
//
//    }

    /**
     * 前序遍历
     * @param root
     */
    public void flatten(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        preorderTraversal(root,list);
        //重构一个而二叉树
        int size = list.size();
        for (int i=1;i<size;i++){
            TreeNode prev = list.get(i-1),curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if (root != null){
            list.add(root);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }

}
