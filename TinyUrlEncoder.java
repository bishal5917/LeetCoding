import java.util.HashMap;

public class TinyUrlEncoder {

    // Hashmap to the rescue
    HashMap<String, String> encoded = new HashMap<>();
    HashMap<String, String> decoded = new HashMap<>();
    String baseUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encoded.containsKey(longUrl)) {
            // if already encoded
            return encoded.get(longUrl);
        }
        long currTime = System.currentTimeMillis();
        String res = baseUrl + String.valueOf(currTime);
        encoded.put(longUrl, res);
        decoded.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decoded.get(shortUrl);
    }

    public static void main(String[] args) {
        TinyUrlEncoder obj = new TinyUrlEncoder();
        System.out.println(obj.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}
