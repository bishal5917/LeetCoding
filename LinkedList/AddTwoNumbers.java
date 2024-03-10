package LinkedList;

import java.util.Stack;

public class AddTwoNumbers {

    ListNode head = null;
    ListNode curr = head;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // lets push to the stack and keep popping till both are null
        ListNode currA = l1;
        ListNode currB = l2;
        Stack<Integer> stacka = addNumsInReverse(new Stack<>(), currA);
        Stack<Integer> stackb = addNumsInReverse(new Stack<>(), currB);
        System.out.println(stacka);
        System.out.println(stackb);
        int carry = 0;
        while (!stacka.isEmpty() && !stackb.isEmpty()) {
            int a = stacka.pop();
            int b = stackb.pop();
            int sum = a + b + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAnswerNode(ans);
        }
        while (!stacka.isEmpty()) {
            int a = stacka.pop();
            int sum = a + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAnswerNode(ans);
        }
        while (!stackb.isEmpty()) {
            int b = stackb.pop();
            int sum = b + carry;
            int ans = sum % 10;
            carry = sum / 10;
            addAnswerNode(ans);
        }
        // Now add the carry if its not zero
        if (carry > 0) {
            addAnswerNode(carry);
        }
        // traverse and push nums to the stack
        printList();
        return head;
    }

    private Stack<Integer> addNumsInReverse(Stack<Integer> st, ListNode head) {
        if (head == null) {
            return st;
        }
        addNumsInReverse(st, head.next);
        st.push(head.val);
        return st;
    }

    public void addAnswerNode(int val) {
        ListNode newNode = new ListNode(val, null);
        if (head == null) {
            head = newNode;
            curr = newNode;
            return;
        }
        curr.next = newNode;
        curr = curr.next;
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
        AddTwoNumbers obj = new AddTwoNumbers();
        MyLinkedList lla = new MyLinkedList();
        lla.addAtTail(2);
        lla.addAtTail(4);
        lla.addAtTail(3);
        MyLinkedList llb = new MyLinkedList();
        llb.addAtTail(5);
        llb.addAtTail(6);
        llb.addAtTail(4);
        obj.addTwoNumbers(lla.head, llb.head);
    }
}
