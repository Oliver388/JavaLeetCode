package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author linglifan
 * @date 2022/09/15 20:48
 */
public class palindromeLinkedList234 {
//    public boolean isPalindrome(ListNode head) {
//        ListNode curr = head;
//        ArrayList<Integer> list = new ArrayList<>();
//        while (curr != null){
//            list.add(curr.val);
//            curr = curr.next;
//        }
//
//        int length = list.size();
//        for (int i=0;i<length-1/2;i++){
//            if (list.get(i) == list.get(length - 1-i)){
//                continue;
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(ListNode head){
        if (head == null){
            return true;
        }

        //寻找前半部分链表的尾节点，采用双指针法
        ListNode endOfFirst = findEndOfFirst(head);
        //反转后半部分链表
        ListNode reversedSecond = reverseList(endOfFirst.next);

        //判断是否是回文
        ListNode p1 = head;
        ListNode p2 = reversedSecond;

        boolean result = true;
        while (result && p2 != null){
            if (p1.val != p2.val){
                result = false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        //还原链表并且返回结果
        endOfFirst.next = reverseList(reversedSecond);
        return result;

    }

    private ListNode findEndOfFirst(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
