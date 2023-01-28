package solution;

import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 按照题目的进阶要求 应该用归并排序
 * @author linglifan
 * @date 2022/09/09 19:23
 */
public class SortList148 {

    public ListNode sortList(ListNode head){
        ListNode dummyhead = head;
        ListNode res = head;

        PriorityQueue<Integer> list = new PriorityQueue<>((o1, o2) -> o1-o2);
        while (dummyhead != null){
            list.add(dummyhead.val);
            dummyhead = dummyhead.next;
        }

        while (res != null){
            res.val = list.poll();
            res = res.next;

        }

        return head;
    }

    //归并排序
//    public ListNode sortList(ListNode head){
//        if (head == null) return head;
//        ListNode node = head;
//        int length = 0;
//        while (node != null){
//            node = node.next;
//            length++;
//        }
//
//        ListNode dummyHead = new ListNode(0, head);
//        for (int subLength=1;subLength<length;subLength<<=1){
//            ListNode prev = dummyHead;
//            ListNode curr = dummyHead.next;
//            while (curr != null){
//                //拆分第一个链表
//                ListNode head1 = curr;
//                for (int i=1;i<subLength && curr!=null;i++){
//                    curr = curr.next;
//                }
//
//                //拆分第二个链表
//                ListNode head2 = curr.next; // 第二个链表的头  即 链表1尾部的下一个位置
//                curr.next = null; // 断开第一个链表和第二个链表的链接
//                curr = head2;  // 第二个链表头 重新赋值给curr
//                for (int j= 1;j<subLength && curr != null;j++){
//                    curr = curr.next;
//                }
//
//                //再次断开 第二个链表最后的next的链接
//                ListNode next = null;
//                if (curr != null){
//                    next = curr.next;
//                    curr.next = null;
//                }
//
//                ListNode merged = mergeTwoLists(head1,head2);
//                prev.next = merged;
//                while(prev.next != null){  // while循环 将prev移动到 subLen*2 的位置后去
//                    prev = prev.next;
//                }
//                curr = next;
//            }
//        }
//        return dummyHead.next;
//    }
//
//    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
//        ListNode merge = new ListNode(0);
//        ListNode prev = merge;
//        prev.next = l1 == null? l2:l1;
//        while (l1 != null && l2 != null){
//            if (l1.val < l2.val){
//                prev.next = l1;
//                l1 = l1.next;
//            }else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        return merge.next;
//    }
}
