package solution;

import sun.java2d.jules.JulesRenderingEngine;

import java.util.*;

/**
 * @author linglifan
 * @date 2022/09/25 10:33
 */
public class SSS {
    public List<Integer> goodIndices(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i=k;i<n-k;i++){
            if (judgeDsc(nums,i) && judgeAsc(nums,i)){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }

    public boolean judgeDsc(int[] nums,int index){
        int n = nums.length;
        for (int j=index;j<n-1;j++){
            if (nums[j]-nums[j+1] > 0){
                return false;
            }
        }
        return true;
    }

    public boolean judgeAsc(int[] nums,int index){
        int n = nums.length;
        for (int j=0;j<index;j++){
            if (nums[j] - nums[j+1] <0){
                return false;
            }
        }

        return true;
    }
}
