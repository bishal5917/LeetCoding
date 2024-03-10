package LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {

    ListNode head = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // lets push to the stack and keep popping till both are null
        Stack<Integer> stacka = new Stack<>();
        Stack<Integer> stackb = new Stack<>();
        ListNode curr = l1;
        while (curr != null) {
            stacka.push(curr.val);
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            stackb.push(curr.val);
            curr = curr.next;
        }
        System.out.println(stacka);
        System.out.println(stackb);
        int carry = 0;
        while (!stacka.isEmpty() && !stackb.isEmpty()) {
            int a = stacka.pop();
            int b = stackb.pop();
            int sum = a + b + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAtHead(ans);
        }
        while (!stacka.isEmpty()) {
            int a = stacka.pop();
            int sum = a + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAtHead(ans);
        }
        while (!stackb.isEmpty()) {
            int b = stackb.pop();
            int sum = b + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAtHead(ans);
        }
        // Now add the carry if its not zero
        if (carry > 0) {
            addAtHead(carry);
        }
        // traverse and push nums to the stack
        printList();
        return head;
    }

    // Constant time complexity
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, null);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        newNode.next = temp;
        head = newNode;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbersII obj = new AddTwoNumbersII();
        MyLinkedList lla = new MyLinkedList();
        lla.addAtTail(0);
        lla.addAtTail(2);
        lla.addAtTail(4);
        lla.addAtTail(3);
        MyLinkedList llb = new MyLinkedList();
        llb.addAtTail(7);
        llb.addAtTail(3);
        llb.addAtTail(6);
        llb.addAtTail(4);
        obj.addTwoNumbers(lla.head, llb.head);
    }
}
