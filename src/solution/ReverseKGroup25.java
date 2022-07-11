package solution;

import java.util.ArrayList;

/**
 * @id 25
 * @author linglifan
 * @date 2022/07/11 09:43
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        ListNode next;
        ListNode curr = head;
        ListNode prev = dummyHead;
        dummyHead.next = head;
        int n = 0;
        while (head !=null){
            n++;
            head = head.next;
        }
        head = dummyHead.next;
        for (int i=0;i<n/k;i++){
            for (int j=0;j<k-1;j++){
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;

            }
            prev = curr;
            curr = prev.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReverseKGroup25 reverse = new ReverseKGroup25();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListNode formedListNode = FormListNode.formListNode(list);
        ListNode reversedListNode = reverse.reverseKGroup(formedListNode, 3);
        while (reversedListNode != null){
            System.out.println(reversedListNode.val);
            reversedListNode = reversedListNode.next;
        }
    }
}
