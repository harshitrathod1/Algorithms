package trees;

import java.util.*;

public class VerticalOrder {

    static void width(Node root,int hl,int[] arr){
        if(root == null) return;

        arr[0] = Math.min(arr[0],hl);
        arr[1] = Math.max(arr[1],hl);

        width(root.left,hl-1,arr);
        width(root.right,hl+1,arr);
    }

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        getVerticalOrder(root);
        getVertical(root);
    }

    static class Pair{
        int x;
        int y;
        Node node;
        Pair(int x,int y,Node node){
            this.x = x;
            this.y = y;
            this.node = node;
        }
        Pair(int x,Node node){
            this.x = x;
            this.node = node;
        }
    }

    //O(N^2) Algorithm
    static void getVerticalOrder(Node root){
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0,0,root));

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            map.putIfAbsent(cur.x,new TreeMap<>());
            map.get(cur.x).putIfAbsent(cur.y,new PriorityQueue<>());
            map.get(cur.x).get(cur.y).offer(cur.node.val);

            if(cur.node.left != null) queue.offer(new Pair(cur.x - 1, cur.y +1,cur.node.left));
            if(cur.node.right != null) queue.offer(new Pair(cur.x + 1,cur.y + 1,cur.node.right));
        }

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry : map.entrySet()){

            TreeMap<Integer,PriorityQueue<Integer>> inner = entry.getValue();
            ArrayList<Integer> subList = new ArrayList<>();

            for(Map.Entry<Integer,PriorityQueue<Integer>> entryInner : inner.entrySet()){
                PriorityQueue<Integer> values = entryInner.getValue();
                while(!values.isEmpty()){
                    int popValue = values.poll();
                    subList.add(popValue);
                }
            }
            mainList.add(subList);
        }

        System.out.println(mainList);
    }

    //O(N) Algorithm
    static void getVertical(Node root){
        if(root == null) return;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int[] arr = new int[2];
        width(root,0,arr);
        int len = arr[1] - arr[0] + 1;

        for(int i = 0;i < len;i++) ans.add(new ArrayList<>());

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(Math.abs(arr[0]), root));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Pair top = queue.poll();
                ans.get(top.x).add(top.node.val);

                if(top.node.left != null) queue.offer(new Pair(top.x - 1, top.node.left));

                if(top.node.right != null) queue.offer(new Pair(top.x+1,top.node.right));
            }
        }

        System.out.println(ans);
    }

}
