package solution;

/**
 * @author linglifan
 * @date 2022/09/18 20:11
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int count = 0;
        while (z != 0){
            z &= z-1;
            count++;

        }
        return count;
    }
}
