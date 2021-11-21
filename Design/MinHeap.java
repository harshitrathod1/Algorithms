package Design;

import java.util.ArrayList;

public class MinHeap{

    private ArrayList<Integer> binaryTree;
    public MinHeap(){
        binaryTree = new ArrayList<>();
    }

    public void add(int val){
        binaryTree.add(val);
        int index = binaryTree.size() - 1;

        heapify_up(index);
    }

    public Integer peek(){
        if(binaryTree.size() == 0) return null;
        return binaryTree.get(0);
    }

    public Integer poll(){
        /*
            1. Swap last pos and root pos
            2. heapifyDown(rootpos)
        * */
        if(binaryTree.size() == 0){
            return null;
        }

        swap(0,binaryTree.size() - 1);
        int removeVal = binaryTree.get(binaryTree.size() - 1);
        binaryTree.remove(binaryTree.size() - 1);
        heapify_down(0);

        return removeVal;
    }

    private void swap(int i,int j){
        int temp = binaryTree.get(i);
        binaryTree.set(i,binaryTree.get(j));
        binaryTree.set(j,temp);
    }

    private void heapify_up(int index){
        if(index == 0) return;

        if(index > 0 && binaryTree.get(parent(index)) > binaryTree.get(index)){
            swap(parent(index),index);
            heapify_up(parent(index));
        }
    }

    private void heapify_down(int index){

        int left = leftChild(index);
        int right = rightChild(index);

        int smallest = index;

        if(left < binaryTree.size() && binaryTree.get(left) < binaryTree.get(index)){
            smallest = left;
        }

        if(right < binaryTree.size() && binaryTree.get(right) < binaryTree.get(smallest)){
            smallest = right;
        }

        if(smallest != index){
            swap(index,smallest);
            heapify_down(smallest);
        }
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    public static void main(String[] args) {
        MinHeap pq = new MinHeap();

        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(5);
        pq.add(15);

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        //System.out.println(pq.binaryTree);
        System.out.println(pq.peek());
        //System.out.println(pq.binaryTree);
        System.out.println(pq.poll());
        //System.out.println(pq.binaryTree);
        System.out.println(pq.poll());
        //System.out.println(pq.binaryTree);
        System.out.println(pq.peek());
        System.out.println(pq.binaryTree);
    }
}
