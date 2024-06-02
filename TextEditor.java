
class TextEditor {

    StringBuilder st;
    int cursor;

    public TextEditor() {
        this.st = new StringBuilder();
        this.cursor = 0;
    }

    public void addText(String text) {
        // Lets just add the values after the cursor
        st.insert(cursor, text);
        cursor += text.length();
        // System.out.println(st);
        // System.out.println(cursor);
    }

    public int deleteText(int k) {
        int deleted = 0;
        while (k > 0) {
            if (cursor - 1 >= 0) {
                st.deleteCharAt(cursor - 1);
                cursor -= 1;
                deleted += 1;
            }
            k -= 1;
        }
        // System.out.println(st);
        // System.out.println(cursor);
        // System.out.println(deleted);
        return deleted;
    }

    public String cursorLeft(int k) {
        StringBuilder str = new StringBuilder();
        // Lets move the cursor left
        cursor = cursor - k;
        // cant move beyond 0 after actual text
        cursor = Math.max(cursor, 0);
        int cursorPos = cursor;
        // No time to get prev 10 chars
        for (int i = 0; i < Math.min(10, cursorPos); i++) {
            str.append(st.charAt(cursor - 1));
            cursor--;
        }
        cursor = cursorPos;
        return str.reverse().toString();
    }

    public String cursorRight(int k) {
        StringBuilder str = new StringBuilder();
        // Lets move the cursor forward
        cursor = k + cursor;
        // cant move forward after actual text
        cursor = Math.min(cursor, st.length());
        int cursorPos = cursor;
        // No time to get prev 10 chars
        for (int i = 0; i < Math.min(10, cursorPos); i++) {
            str.append(st.charAt(cursor - 1));
            cursor--;
        }
        cursor = cursorPos;
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        TextEditor obj = new TextEditor();
        obj.addText("leetcode");
        System.out.println(obj.deleteText(4));
        obj.addText("practice");
        System.out.println(obj.cursorRight(3));
        System.out.println(obj.cursorLeft(8));
        System.out.println(obj.deleteText(10));
        System.out.println(obj.cursorLeft(2));
        System.out.println(obj.cursorRight(6));
    }
}
