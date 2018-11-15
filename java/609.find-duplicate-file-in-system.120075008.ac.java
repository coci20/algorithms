class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> lists = new ArrayList<>();
        if(paths.length == 0) {
            lists.add(new ArrayList<String>());
            return lists;
        }
        
        Map<String,List<String>> map = new HashMap<>();
        int i, j;
        for(i = 0; i < paths.length; i++) {
            String[] parts = paths[i].split(" ");
            for(j = 1; j < parts.length; j++) {
                String[] comps = parts[j].split("\\.txt");
                String fname = comps[0];
                String content = comps[1];
                String path = parts[0] + "/" + fname + ".txt";
                if(!map.containsKey(content)) {
                    List<String> val = new ArrayList<>();
                    val.add(path);
                    map.put(content,val);
                } else {
                    map.get(content).add(path);
                }
            }
        }
        for(String s : map.keySet()) {
            if(map.get(s).size() > 1)
                lists.add(map.get(s));
        }
        return lists;
    }
}
