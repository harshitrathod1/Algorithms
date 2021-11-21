package Design;

import java.util.LinkedList;

public class HashMap<K,V> {
    /**
        1. Load Factor = Average number of Entries per Bucket (0.75 default)
        2. capacity = number of buckets
        3. entries = total no of key value pairs
        4. Threshold = LoadFactor * capacity = 0.75 * 16 = 12 i.e. after entries become more than 12
        resize or rehash the table
    **/
    /*
        1. Put Method
        2. Get Method
        3. ContainsKey Method
        4. remove Method
        5. keySet Method
    */
    private class Node{
        K key;
        V value;
        Node(K _key,V _value){
            this.key = _key;
            this.value = _value;
        }
    }

    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 4;

    private int capacity; // no of buckets
    private int entries; // no of <K,V> pairs
    private double loadFactor;
    private LinkedList<Node>[] buckets;
    private int threshold; // size * loadFactor

    public HashMap(){
        this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int cap){this(cap,DEFAULT_LOAD_FACTOR);}

    public HashMap(int cap,double loadFactor){
        if(cap < 0) throw new IllegalArgumentException("Capacity cannot be zero");

        this.capacity = cap;
        this.loadFactor = loadFactor;
        this.entries = 0;
        this.buckets = new LinkedList[this.capacity];
        this.threshold = (int) (this.capacity * this.loadFactor);

        for(int bucketIndex = 0;bucketIndex < this.capacity;bucketIndex++){
            this.buckets[bucketIndex] = new LinkedList<>();
        }
    }

    private int getInsideBucketIndex(K key, int bucketIndex) {

        int index = 0;

        for(Node node : buckets[bucketIndex]){
            if(node.key.equals(key)){
                return index;
            }
            index++;
        }

        return -1;
    }

    private int getHash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key,V value){
        if(key == null) throw new IllegalArgumentException("Key is Null");

        int bucketIndex = getHash(key);
        int insideBucketIndex = getInsideBucketIndex(key,bucketIndex);

        if(insideBucketIndex != -1){
            Node existingNode = buckets[bucketIndex].get(insideBucketIndex);
            existingNode.value = value;
        }else{
            Node newNode = new Node(key,value);
            buckets[bucketIndex].add(newNode);
            entries += 1;
        }

        if(entries > threshold) resizeHashTable();

    }

    public boolean containsKey(K key){
        if(key == null) throw new IllegalArgumentException("Key is Null");

        int bucketIndex = getHash(key);
        int insideBucketIndex = getInsideBucketIndex(key,bucketIndex);

        if(insideBucketIndex != -1){
            return true;
        }else{
            return false;
        }
    }

    public V get(K key){
        if(key == null) throw new IllegalArgumentException("Key is Null");

        int bucketIndex = getHash(key);
        int insideBucketIndex = getInsideBucketIndex(key,bucketIndex);

        if(insideBucketIndex != -1){
            Node node = buckets[bucketIndex].get(insideBucketIndex);
            return node.value;
        }else{
            return null;
        }
    }

    public V remove(K key){
        if(key == null) throw new IllegalArgumentException("Key is Null");

        int bucketIndex = getHash(key);
        int insideBucketIndex = getInsideBucketIndex(key,bucketIndex);

        if(insideBucketIndex != -1){
            Node node = buckets[bucketIndex].remove(insideBucketIndex);
            entries -= 1;
            return node.value;
        }else{
            return null;
        }
    }

    public int getSize(){
        return entries;
    }

    private void resizeHashTable() {
        capacity *= 2;
        threshold = (int) (capacity * loadFactor);

        LinkedList<Node>[] newBuckets = new LinkedList[capacity];

        for(int i = 0;i < capacity;i++){
            newBuckets[i] = new LinkedList<>();
        }

        for(int i = 0;i < buckets.length;i++){
            for(Node node : buckets[i]){
                Node newEntry = new Node(node.key, node.value);
                int bucketIndex = getHash(node.key);
                newBuckets[bucketIndex].add(newEntry);
            }
        }

        buckets = newBuckets;
    }

    public void getItems(){

        int entriesIndex = 0;

        for(int i = 0;i < capacity;i++){
            if(buckets[i].isEmpty()) continue;
            for(Node node: buckets[i]){
                String keyData = String.valueOf(node.key);
                String valueData = String.valueOf(node.value);
                System.out.println(keyData+" "+valueData);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("India",1);
        map.put("Australia",2);
        map.put("New Zealand",3);
        map.put("South Africa",4);
        map.put("England",5);
        map.put("West Indies",6);

        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("England"));
        System.out.println(map.remove("England"));
        map.getItems();
        System.out.println(map.containsKey("England"));
        System.out.println(map.get("New Zealand"));
    }
}
