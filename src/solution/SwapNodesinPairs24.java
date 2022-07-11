package solution;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @id 24
 * @author linglifan
 * @date 2022/07/10 20:48
 */
public class SwapNodesinPairs24 {
    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairsRecursive(ListNode head){
        // base case 退出提交
        if (head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode nNode = head.next;
        // 进行递归
        ListNode newNode = swapPairsRecursive(nNode.next);
        // 这里进行交换
        nNode.next = head;
        head.next = newNode;
        return nNode;
    }
    /**
     * 虚拟头节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode prev = dummyhead;
        while (prev.next != null && prev.next.next != null){
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;

        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        SwapNodesinPairs24 swapNodesinPairs24 = new SwapNodesinPairs24();
        ListNode list1 = new ListNode(1);
        ListNode present, node;
        present = list1;

        node = new ListNode(2);
        present.next = node;
        present = present.next;

        node = new ListNode(3);
        present.next = node;
        present = present.next;

        node = new ListNode(4);
        present.next = node;
        present = present.next;
        ListNode listNode = swapNodesinPairs24.swapPairs(list1);
        System.out.println(listNode);
    }
}
