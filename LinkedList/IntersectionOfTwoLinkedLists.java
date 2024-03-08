package LinkedList;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Lets travel and find the length first
        int lenA = 0;
        ListNode temp = headA;
        while (temp != null) {
            lenA += 1;
            temp = temp.next;
        }
        int lenB = 0;
        temp = headB;
        while (temp != null) {
            lenB += 1;
            temp = temp.next;
        }
        // System.out.println(lenA + "&&" + lenB);
        // Now lets traverse to starting point for the longest node
        ListNode tempA = headA;
        ListNode tempB = headB;
        int diff = Math.abs(lenA - lenB);
        if (lenA < lenB) {
            while (diff > 0) {
                tempB = tempB.next;
                diff -= 1;
            }
        } else if (lenA > lenB) {
            while (diff > 0) {
                tempA = tempA.next;
                diff -= 1;
            }
        }
        // Now start checking for the same node
        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return new ListNode();
    }

    public static void main(String[] args) {
        MyLinkedList la = new MyLinkedList();
        la.addAtTail(4);
        la.addAtTail(1);
        la.addAtTail(8);
        la.addAtTail(4);
        la.addAtTail(5);
        MyLinkedList lb = new MyLinkedList();
        lb.addAtTail(5);
        lb.addAtTail(6);
        lb.addAtTail(1);
        lb.addAtTail(8);
        lb.addAtTail(4);
        lb.addAtTail(5);
        IntersectionOfTwoLinkedLists obj = new IntersectionOfTwoLinkedLists();
        System.out.println(obj.getIntersectionNode(la.head, lb.head).val);
    }
}
