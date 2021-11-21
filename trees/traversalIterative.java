package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class traversalIterative {

    static Map<Node,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        allTraversals(root);
    }

    static void allTrav(Node root){
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        map.putIfAbsent(root,0);
        String pre = "",inor = "",post = "";

        while(!stack.isEmpty()){
            Node cur = stack.peek();

            if (cur == null) { stack.pop(); continue;}
            else if(map.get(cur) == 0) {
                pre += cur.val+" ";
                stack.push(cur.left);
                if(cur.left != null) map.putIfAbsent(cur.left,0);
            }
            else if(map.get(cur) == 1){
                inor += cur.val+" ";
                stack.push(cur.right);
                if(cur.right != null) map.putIfAbsent(cur.right,0);
            }
            else if(map.get(cur) == 2) {
                post += cur.val+" ";
            }
            else stack.pop();
            map.put(cur,map.get(cur)+1);
        }

        System.out.println(pre);
        System.out.println(inor);
        System.out.println(post);
    }

    static class Pair{
        Node node;
        int state;
        Pair(Node n,int state){
            this.node = n;
            this.state = state;
        }
    }

    static void allTraversals(Node root){

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,0));

        String pre = "",in = "",post ="";

        while (!stack.isEmpty()){
            Pair p = stack.peek();

            if(p.state == 0){
                pre += p.node.val+" ";
                p.state++;
                if(p.node.left != null) stack.push(new Pair(p.node.left,0));
            }else if(p.state == 1){
                in += p.node.val + " ";
                p.state++;
                if(p.node.right != null) stack.push(new Pair(p.node.right,0));
            }else if(p.state == 2){
                post += p.node.val+" ";
                stack.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
