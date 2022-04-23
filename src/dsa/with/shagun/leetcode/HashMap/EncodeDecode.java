package dsa.with.shagun.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecode {

    public static void main(String[] args) {
        System.out.println(encode("https://Leetcode.com"));
        System.out.println(decode("http://tinyurl.com/-58207657"));
    }

    static String BASE_HOST = "http://tinyurl.com/";
    static Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        String key = BASE_HOST + hashCode;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
