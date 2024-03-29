package solution;

/**
 * @author linglifan
 * @date 2022/09/29 19:59
 */
public class HouseRobber337 {
    public int rob(TreeNode root) {
        int[] ints = robAction(root);
        return Math.max(ints[0],ints[1]);
    }

    int[] robAction(TreeNode root){
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
