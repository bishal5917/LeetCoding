package LinkedList;

public class WinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {
        int removed = -1;
        // We gotta create a circular linked list first
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= n; i++) {
            ListNode newOne = new ListNode(i);
            temp.next = newOne;
            temp = newOne;
        }
        ListNode lastNode = temp;
        // Connecting the tail to the head (MAKING CIRCULAR)
        lastNode.next = head;
        // ***** NOW TIME TO MOVE EVERY K STEPS AND REMOVE THAT PLAYER *****
        temp = head; // start our temp from head
        // we have to track previous node
        // because we gotta remove the node in between
        // At first lastNode will be the previous one
        ListNode prev = lastNode;
        while (temp != null && prev != null) { // we go till our temp node isn't null
            // we go till k while tracking previous
            for (int i = 1; i < k; i++) {
                prev = temp;
                temp = temp.next;
            }
            // now the current temp.val is the value to be removed
            removed = temp.val;
            // we remove the temp node
            prev.next = temp.next;
            // we disconnect the link
            temp.next = null;
            // set our next temp
            temp = prev.next;
        }
        // The last one removed is the winner
        return removed;
    }

    public static void main(String[] args) {
        WinnerOfTheCircularGame obj = new WinnerOfTheCircularGame();
        int n = 5;
        int k = 2;
        System.out.println(obj.findTheWinner(n, k));
    }
}
