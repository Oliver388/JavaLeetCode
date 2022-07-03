package solution;


/**
 * @id 11
 * @author linglifan
 * @date 2022/07/03 13:00
 */
public class ContainerWithMostWater11 {

    /**
     * 暴力超时
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int sum=0;
        for (int i=0;i<height.length-1;i++){
            for (int j=height.length-1;j>0;j--){
                int longer = Math.min(height[i],height[j]);
                int temp = (j-i) * longer;
                sum = Math.max(sum,temp);

            }
        }
        return sum;
    }

    /**
     * 双指针法：对应数字较小的那个指针以后不可能作为容器的边界了，将其丢弃，并移动对应的指针。(不要问为什么，就是这样)
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int sum = 0;
        int i=0;
        int j = height.length-1;
        while (i<j){
            int temp = Math.min(height[i],height[j]) * (j-i);
            sum = Math.max(sum,temp);
            if (height[i] <= height[j]){
                i = i+1;
            }else {
                j = j-1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 temp = new ContainerWithMostWater11();
        System.out.println(temp.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}