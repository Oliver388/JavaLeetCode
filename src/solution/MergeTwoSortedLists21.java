package solution;

/**
 * @id 21
 * @author linglifan
 * @date 2022/07/09 13:31
 */
public class MergeTwoSortedLists21 {
    /**
     * 递归(递归真的不会)
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsByRecursive(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }else if (list1.val < list2.val){
            list1.next = mergeTwoListsByRecursive(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoListsByRecursive(list1,list2.next);
            return list2;
        }
    }
    /**
     * 迭代
     * 时间复杂度：O(n+m)
     * 空间复杂度: O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoListsByIterate(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(0);
        ListNode prev = merge;
        while (list1 != null && list2!= null){
            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null? list2 : list1;
        return merge.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists21 twoSortedLists = new MergeTwoSortedLists21();
        ListNode list1 = new ListNode(1);
        ListNode present, node;
        present = list1;

        node = new ListNode(2);
        present.next = node;
        present = present.next;

        node = new ListNode(3);
        present.next = node;
        present = present.next;

        ListNode list2 = new ListNode(1);
        present = list2;
        int[] l2_data = {3,4};
        for (int i :
                l2_data) {
            node = new ListNode(i);
            present.next = node;
            present = present.next;
        }

        ListNode merge = twoSortedLists.mergeTwoListsByIterate(list1, list2);
        ListNode i = merge;
        while (i != null){
            System.out.println(i.val);
            i = i.next;
        }
    }

}


