package solution;

import apple.laf.JRSUIUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author linglifan
 * @date 2023/01/14 14:09
 */
public class lc98 {
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= prev) return false;
        prev = root.val;
        if (!isValidBST(root.right)) return false;
        return true;


    }
}
