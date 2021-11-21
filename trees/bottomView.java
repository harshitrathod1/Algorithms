package trees;

import java.util.*;

public class bottomView {

    //Last Node in x coordinate of every level;
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        getBottomView(root);
    }

    static class Pair{
        int x;
        int y;
        Node node;
        Pair(int _x,int _y,Node _node){
            this.x = _x;
            this.y = _y;
            this.node = _node;
        }
        Pair(int _x,Node root){
            x = _x;
            node = root;
        }
    }


    static void getWidth(Node root,int hl,int[] arr){
        if(root == null) return;

        arr[0] = Math.min(arr[0],hl);
        arr[1] = Math.max(arr[1],hl);

        getWidth(root.left,hl-1,arr);
        getWidth(root.right,hl+1,arr);
    }

    static void getBottomView(Node root){
        if(root == null) return;

        //ArrayList<Integer> bottom = new ArrayList<>();
        int[] arr = new int[2];
        getWidth(root,0,arr);
        //System.out.println(arr[0]+" "+arr[1]);
        int len = arr[1] - arr[0] + 1;
        //System.out.println(len);

        int[] bottom = new int[len];

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(Math.abs(arr[0]),root));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Pair top = queue.poll();
                bottom[top.x] = top.node.val;

                if(top.node.left != null) queue.offer(new Pair(top.x - 1,top.node.left));
                if(top.node.right != null) queue.offer(new Pair(top.x + 1,top.node.right));
            }
        }

        for(int elem:bottom){
            System.out.print(elem+" ");
        }
    }
}
