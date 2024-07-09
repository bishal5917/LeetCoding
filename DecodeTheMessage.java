import java.util.Arrays;
import java.util.HashMap;

public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder msg = new StringBuilder();
        Character[] albs = new Character[26];
        char c = 'a';
        for (int i = 0; i < albs.length; i++) {
            albs[i] = c++;
        }
        System.out.println(Arrays.toString(albs));
        // Now time to put the key into a hashmap
        int idx = 0;
        for (char ch : key.toCharArray()) {
            if (map.containsKey(ch) || ch == ' ') {
                continue;
            }
            map.put(ch, albs[idx++]);
        }
        // Now time to decode the message
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                msg.append(" ");
                continue;
            }
            msg.append(map.get(ch));
        }
        return msg.toString();
    }

    public static void main(String[] args) {
        DecodeTheMessage obj = new DecodeTheMessage();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(obj.decodeMessage(key, message));
    }
}
