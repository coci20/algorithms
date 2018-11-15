class LRUCache {
    class Node {
        int k;
        int val;
        Node (int x, int v) {
            k = x;
            val = v;
        }
    }
    int size = 0;
    List<Node> list;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public int get(int key) {
        if(map.size() == 0 || !map.containsKey(key))
            return -1;
        Node n = map.get(key);
        int value = n.val;
        int index = list.indexOf(n);
        n = list.remove(index);
        list.add(n);
        return value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key) && 
           map.size() == size) {
            Node n = list.remove(0);
            map.remove(n.k);
        }
        if(map.containsKey(key)) {
            int index = list.indexOf(map.get(key));
            Node n = list.remove(index);            
            list.add(n);
            map.get(key).val = value;
            return;
        }
        Node nv = new Node(key, value);
        map.put(key, nv);
        list.add(nv);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
