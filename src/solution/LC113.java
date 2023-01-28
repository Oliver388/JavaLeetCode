package solution;

import java.util.List;

/**
 * @author linglifan
 * @date 2022/12/09 16:04
 */
public class LC113 {
    List<Integer> path;
    List<List<Integer>> result;
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//    }

    private void dfs(TreeNode root,int targetSum,List<Integer> path,
                     List<List<Integer>> result){
        path.add(root.val);
        if (root.left == null && root.right == null){

        }

        if (root.left != null){

        }
    }
}
