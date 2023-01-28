package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author linglifan
 * @date 2022/12/07 15:38
 */
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        dfs(root,path,result);
        return result;
    }

    private void dfs(TreeNode root,List<Integer> path, List<String> result){
        path.add(root.val);
        if (root.left == null && root.right == null){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                stringBuilder.append(path.get(i)).append("->");
            }
            stringBuilder.append(path.get(path.size() - 1));
            result.add(stringBuilder.toString());
            return;
        }
        if (root.left != null){
            dfs(root.left, path,result);
            path.remove(path.size() -1); //回溯
        }

        if (root.right != null){
            dfs(root.right, path,result);
            path.remove(path.size() - 1);//回溯
        }
    }
}
