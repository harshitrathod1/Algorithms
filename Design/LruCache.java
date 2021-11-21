package Design;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    private Map<Integer,Node> map = new HashMap<>();
    private int capacity;

    public LruCache(int _capacity){
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key,int value){
        // 1. Check if key already there remove it
        // 2. check if size == capacity, if so remove tail
        // 3. Insert new reference of node key,value
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    //handles both removal from map and LL
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //insert at the head
    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }

    public int getCapacity() {
        return capacity;
    }

    //LinkedList Node
    class Node{
        Node prev,next;
        int key,value;
        Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        System.out.println(cache.get(1));
        cache.put(4,40);
        System.out.println(cache.get(2));
    }
}
