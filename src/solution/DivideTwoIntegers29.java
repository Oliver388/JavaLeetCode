package solution;

/**
 * @id 29
 * @author linglifan
 * @date 2022/07/11 19:27
 */
public class DivideTwoIntegers29 {
    //Fixme
    public int divide(int dividend, int divisor) {


        int flag=0;
        if (dividend>0 && divisor>0){
            flag = 1;
        }else if (dividend<0 && divisor<0){
            flag = 1;
        }else if (dividend<0 || divisor<0){
            flag = -1;
        }

        if (dividend == Integer.MIN_VALUE){
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            if (divisor == -1){
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = 0;
        while (absDividend>=absDivisor){
            result++;
            absDividend = absDividend - absDivisor;

        }
        return result*flag;

    }

    public static void main(String[] args) {
        DivideTwoIntegers29 divideTwoIntegers29 = new DivideTwoIntegers29();
        int divide = divideTwoIntegers29.divide(-2147483648, 2);
        System.out.println(divide);
    }
}
