package solution;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

import java.util.HashSet;

/**
 * @author linglifan
 * @date 2022/09/12 20:27
 */
public class intersectionLists160 {
    //哈希
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        HashSet<ListNode> nodes = new HashSet<>();
//        while (headA != null){
//            nodes.add(headA);
//            headA = headA.next;
//        }
//
//        while (headB != null){
//            if (nodes.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    /**
     * 双指针
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA,pB = headB;
        while (pA != pB){
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        return pA;
    }
}
