package solution;

import apple.laf.JRSUIUtils;

/**
 * @author linglifan
 * @date 2022/10/12 09:49
 */
public class convertBST538 {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBSTHelper(root);
        return root;
    }

    private void convertBSTHelper(TreeNode root){
        if (root == null) return;
        convertBSTHelper(root.right);
        convertBSTHelper(root.left);
        sum += root.val;
        root.val = sum;
    }
}
