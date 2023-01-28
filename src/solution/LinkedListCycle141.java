package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linglifan
 * @date 2022/09/08 19:12
 */
public class LinkedListCycle141 {
    //哈希表
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> listNodes = new HashSet<>();
//        while (head != null){
//            if (!listNodes.add(head)){
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

    //快慢指针
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;

            }

        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle141 linkedListCycle141 = new LinkedListCycle141();
        ListNode list1 = new ListNode(3);
        ListNode present, node;
        present = list1;

        node = new ListNode(2);
        present.next = node;
        present = present.next;

        node = new ListNode(0);
        present.next = node;
        present = present.next;

        node = new ListNode(-4);
        present.next = node;
        present = present.next;
        linkedListCycle141.hasCycle(list1);
        System.out.println(linkedListCycle141.hasCycle(list1));
    }
}
