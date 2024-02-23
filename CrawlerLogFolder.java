import java.util.Stack;

public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        Stack<String> logStack = new Stack<>();
        // just perform push and pop based upon some logic
        for (String log : logs) {
            if (log.equals("../")) {
                if (!logStack.isEmpty()) {
                    logStack.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                logStack.push(log);
            }
        }
        // System.out.println(logStack);
        return logStack.size();
    }

    public static void main(String[] args) {
        CrawlerLogFolder obj = new CrawlerLogFolder();
        String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
        System.out.println(obj.minOperations(logs));
    }

}
