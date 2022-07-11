package solution;

/**
 * @id 7
 * @author linglifan
 * @date 2022/07/03 10:55
 */
public class Reverse7 {

    /**
     * 用int直接处理
     * @param x
     * @return
     */
    public int reverse(int x){
        long n = 0;
        while(x!=0){
            n = n*10 + x%10;
            x = x/10;
        }
        if (n>Integer.MAX_VALUE || n<Integer.MIN_VALUE){
            return 0;
        }
        return (int) n;
    }

    /**
     * 先转成字符串再处理
     * @param x
     * @return
     */
    public int reverse2(int x){
        String s = Integer.toString(x);
        String xs = s;
        int flag = 1;
        if (x<0){
            flag = -1;
            xs = xs.substring(1);
        }
        try {
            return Integer.valueOf(new StringBuilder(xs).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        Reverse7 reverse7 = new Reverse7();
        System.out.println(reverse7.reverse2(-2289422));
    }
}
