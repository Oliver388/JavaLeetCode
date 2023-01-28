package solution;

/**
 * @author linglifan
 * @date 2022/10/01 10:39
 */
public class countingBits338 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for (int i=1;i<=n;i++){
            if (i % 2 == 1){
                result[i] = result[i-1] + 1;

            }else {
                result[i] = result[i/2];
            }
        }

        return result;
    }
}
