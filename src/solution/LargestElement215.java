package solution;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;
import java.util.Random;

/**
 * 手写快排
 * @author linglifan
 * @date 2022/09/15 15:03
 */
public class LargestElement215 {

    Random random = new Random(System.currentTimeMillis());
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums,int left,int right){
        if (left >= right) return;
        int pivotIndex = partition(nums,left,right);
        quickSort(nums,left,pivotIndex - 1);
        quickSort(nums,pivotIndex + 1,right);

    }

    public Integer partition(int[] nums,int left,int right){
        // [left...right]
        int randomIndex = random.nextInt(right -left + 1) + left;
        swap(nums,left,randomIndex);
        int pivot = nums[left];

        int j = left;
        //j is the last element in first section
        //i is the last element in second section
        //all in nums[left+1...j] <= pivot
        //all in nums(j..i) > pivot
        for (int i=left+1;i <= right;i++){
            if (nums[i] <= pivot){
                j++;
                swap(nums,i,j);
            }
        }

        //把切分的这个位置和第一区间的最后一个元素进行位置交换
        //切分的位置在left
        swap(nums,left,j);
        return j;
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        LargestElement215 largestElement215 = new LargestElement215();
        int a = largestElement215.findKthLargest(new int[]{3,2,1,5,6,4},2);
        System.out.println(a);
    }
}
