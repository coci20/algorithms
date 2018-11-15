public class Codec {

    String alpha = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap<>();
    int n = 10;
    
    //Gives me a random key.
    public String getRandom() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(alpha.charAt((int)(Math.random() * 62)));
        }
        return sb.toString();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getRandom();
        while(map.containsKey(key))
            key = getRandom();
        String result = "http://tinyurl.com/" + key;
        map.put(key, longUrl);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
