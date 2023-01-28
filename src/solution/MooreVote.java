package solution;

/**
 * @author linglifan
 * @date 2022/11/30 20:47
 */
public class MooreVote {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int vote =0;
        for (int num : nums) {
            if (vote == 0) candidate = num;
            if (candidate == num){
                vote++;
            }else {
                vote--;
            }
        }

        vote = 0;
        for (int num : nums) {
            if (candidate == num){
                vote++;
            }
        }
        return vote <= nums.length/2 ? -1 : candidate;
    }
}
