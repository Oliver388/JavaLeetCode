package solution;

/**
 * @author linglifan
 * @date 2022/07/01 22:07
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //特殊情况处理
        if(m==0 && n==0){
            return 0;

        }
        if(n==0){
            if(m % 2 != 0){
                return nums1[m/2];
            }else{
                return (double)(nums1[(m/2)-1] + nums1[m/2]) / 2;
            }
        }
        if(m==0){
            if(n % 2 != 0){
                return nums2[n/2];
            }else{
                return (double)(nums2[(n/2)-1] + nums2[n/2]) / 2;
            }
        }

        int num = n + m;
        int[] merge = new int[num];
        int count = 0;
        int i=0;
        int j=0;
        while(count < num){
            while(i<m && j<n){
                if(nums1[i] < nums2[j]){
                    merge[count] = nums1[i];
                    count = count +1;
                    i = i+1;
                }else{
                    merge[count] = nums2[j];
                    count = count +1;
                    j=j+1;
                }
            }
            if(i<m){
                merge[count] = nums1[i];
                count = count+1;
                i=i+1;
            }
            if(j<n){
                merge[count] = nums2[j];
                count = count+1;
                j=j+1;

            }
        }

        //合并中位数
        if(num % 2 != 0){
            return merge[num /2];
        }else {
            return (double)(merge[num / 2 - 1] + merge[num / 2]) /2;
        }

    }

    public static void main(String[] args) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        System.out.println(medianSortedArrays.findMedianSortedArrays(new int[] {1,3},new int[]{2,4}));
    }
}
