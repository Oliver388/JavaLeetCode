package solution;

/**
 * @author linglifan
 * @date 2023/01/16 13:59
 */
public class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key){
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {
                TreeNode cur = root.right;
                while (cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right
                ;
                return root;
            }
        }
        if(root.val > key) root.left = deleteNode(root.left,key);
        if (root.val < key) root.right = deleteNode(root.right,key);
        return root;
    }

//    public TreeNode helper(TreeNode root, int key){
//        if (root == null) return root;
//
//    }
}
