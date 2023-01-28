package solution;

import java.util.Arrays;

/**
 * @author linglifan
 * @date 2023/01/03 13:49
 */
public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }

    public TreeNode helper(int[] nums, int left,int right){
        if (right - left <1) return null;
        if (right - left == 1){
            return new TreeNode(nums[left]);
        }
        int maxValueIndex = left;
        int maxValue = nums[maxValueIndex];
        for (int i = left+1;i<right;i++){
            if (nums[i] > maxValue){
                maxValueIndex = i;
                maxValue = nums[maxValueIndex];

            }
        }

        TreeNode node = new TreeNode(maxValue);
        node.left = helper(nums,left,maxValueIndex);
        node.right = helper(nums,maxValueIndex+1,right);
        return node;
    }
}
