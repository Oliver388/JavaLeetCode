package solution;

import jdk.nashorn.internal.runtime.arrays.IntElements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linglifan
 * @date 2022/10/12 10:00
 */
public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        //这个key的意思是和，value的意思是该和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,count = 0;
        for (int i=0;i< nums.length;i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }

}
