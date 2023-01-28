package solution;

import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

/**
 * @author linglifan
 * @date 2022/09/12 21:06
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int amount = nums.length / 2;
        return nums[amount];
    }
}
