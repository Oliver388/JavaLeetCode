package solution;

/**
 * @author linglifan
 * @date 2022/09/04 19:39
 */
public class BuyStock121 {
    public int maxProfit(int[] prices) {
        //最大收益
        int maxProfit = 0;
        //前i天中的最小价格
        int min = prices[0];
        //代表第i天的最大收益
        //第i天的最大收益计算方法：
        //1. 如果最大收益不是第i天卖出所得到的，那么最大收益和第i天无关
        //2. 最大收益是在第i-1天前的某天买入的，第i天卖出的，那么最大收益与第i天的价格有关
        //因此第i天的最大收益等于：第i天抛出所造成的最大收益 和 第i-1天之前的最大收益 中的最大值
        // 即：
        // 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        // 其中：
        // 前i-1天中的最小价格需时时更新并记录
        for (int i=1;i<=prices.length;i++){
            min = Math.min(prices[i-1],min);
            maxProfit = Math.max(maxProfit,prices[i-1] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyStock121 buyStock121 = new BuyStock121();
        int a = buyStock121.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(a);
    }
}
