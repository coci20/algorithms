class Solution {
    public String replaceWords(List<String> dict, String sentence) {
       Map<String, String> map = new HashMap<>();
        String[] strings = sentence.split(" ");
        for(String w : dict) {
            for(String token: strings) {
                if(token.startsWith(w)) {
                    if(!map.containsKey(token)){
                        map.put(token, w);
                    } else {
                        if(map.get(token).length() > w.length()){
                            map.put(token, w);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strings) {
            if(map.containsKey(s)){
                sb.append(map.get(s));
            } else
                sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim(); 
    }
}
