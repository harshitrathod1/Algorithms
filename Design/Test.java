package Design;

public class Test {
    /*
        private class Node{
        K key;
        V value;

        Node(K _key,V _value){
            key = _key;
            value = _value;
        }
    }

    private int bucketSize; // no of buckets
    private int entries; // total no of key,value pairs
    private LinkedList<Node>[] buckets;

    public HashMap(){
        this(4);
    }

    public HashMap(int bucketSize){
        this.entries = 0;
        this.bucketSize = bucketSize;
        this.buckets = new LinkedList[bucketSize];

        for(int entry = 0;entry < bucketSize;entry++){
            buckets[entry] = new LinkedList<>();
        }
    }

    private int getHash(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private int getIndexInsideBucket(K key, int bucketIndex) {
        int index = 0;
        for(Node node : buckets[bucketIndex]){
            if(node.key.equals(key)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public void put(K key,V value){
        int bucketIndex = getHash(key);
        int indexInsideTheBucket = getIndexInsideBucket(key,bucketIndex);

        if(indexInsideTheBucket != -1) {
            //UpdateCase
            Node node = buckets[bucketIndex].get(indexInsideTheBucket);
            node.key = key;
            node.value = value;
        }else{
            //InsertCase
            Node node = new Node(key,value);
            buckets[bucketIndex].add(node);
            entries += 1;
        }
    }


     */
}
