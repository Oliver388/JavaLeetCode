package solution;

import java.lang.annotation.Repeatable;
import java.util.Arrays;

/**
 * @author linglifan
 * @date 2022/09/04 21:01
 */
public class longestSequence128 {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int length = 0;
        int current = 0;
        while (current < nums.length){
            int newCurrent = current +1;
            int repeat = 0;
            while (newCurrent < nums.length){
                if (nums[newCurrent] == nums[newCurrent-1] + 1){
                    newCurrent++;
                    continue;
                }
                if (nums[newCurrent] == nums[newCurrent-1]){
                    repeat++;
                    newCurrent++;
                    continue;
                }
                break;
            }
            length = Math.max(newCurrent - current -repeat,length);
            current = newCurrent;
        }
        return length;
    }

    public static void main(String[] args) {
        longestSequence128 longestSequence128 = new longestSequence128();
        int a = longestSequence128.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(a);
    }
}
