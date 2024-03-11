package LinkedList;

public class BrowserHistory {

    BrowserNode head;
    BrowserNode curr;

    public BrowserHistory(String homepage) {
        BrowserNode home = new BrowserNode(homepage);
        head = home;
        curr = home;
    }

    public void visit(String url) {
        BrowserNode newNode = new BrowserNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps -= 1;
        }
        return curr.url;
    }

    public String forward(int steps) {
        int count = 0;
        while (count != steps && curr.next != null) {
            curr = curr.next;
            count += 1;
        }
        return curr.url;
    }

    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("lc");
        obj.visit("google");
        obj.visit("fb");
        obj.visit("youtube");
        System.out.println(obj.back(1));
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));
        obj.visit("linkedin");
        System.out.println(obj.forward(2));
        System.out.println(obj.back(2));
    }
}
