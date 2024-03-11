package LinkedList;

class BrowserNode {
    String url;
    BrowserNode next;
    BrowserNode prev;

    BrowserNode() {
    }

    BrowserNode(String url) {
        this.url = url;
    }

    BrowserNode(String url, BrowserNode next, BrowserNode prev) {
        this.url = url;
        this.next = next;
        this.prev = prev;
    }
}
