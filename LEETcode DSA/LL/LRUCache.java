import java.util.HashMap;
public class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode prev;

        ListNode(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private int Capacity;
    private HashMap<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    
    public LRUCache(int capacity) {
        this.Capacity = capacity;
        this.map = new HashMap<>(); 
        this.head = new ListNode(0,0);
        this.tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       if(map.containsKey(key)){
        ListNode node = map.get(key);
        remove(node);
        InsertToHead(node);
        return node.value;
       } 
       else{
        return -1;
       }  
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            ListNode node = map.get(key);
            node.value = value;
            remove(node);
            InsertToHead(node);
        }
        else{
            if(map.size() == Capacity)
            {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            InsertToHead(node);
        }
        
    }
    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void InsertToHead(ListNode node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
        
    }
}
