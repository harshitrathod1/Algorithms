package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class burningTree {
    //map<node,parent>

    private Node burnNode;
    void getParents(Node root, HashMap<Node,Node> parents){
        if(root == null) return;

        if(root.left != null){
            parents.put(root.left,root);
            getParents(root.left,parents);
        }
        if(root.right != null){
            parents.put(root.right,root);
            getParents(root.right,parents);
        }
    }

    void getNodeReference(Node root,int B){
        if(root.val == B){
            burnNode = root;
            return;
        }

        if(root.left != null) getNodeReference(root.left,B);
        if(root.right != null) getNodeReference(root.right,B);
    }
    public int solve(Node root, int B) {
        if(root == null) return 0;
        HashMap<Node,Node> parents = new HashMap<>();
        int time = 0;

        getParents(root,parents);
        getNodeReference(root,B);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(burnNode);
        HashSet<Node> seen = new HashSet<>();

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node cur = queue.poll();
                seen.add(cur);

                if(cur.left != null && !seen.contains(cur.left)){
                    queue.offer(cur.left);
                }

                if(cur.right != null && !seen.contains(cur.right)){
                    queue.offer(cur.right);
                }

                if(parents.get(cur) != null && !seen.contains(parents.get(cur))){
                    queue.offer(parents.get(cur));
                }

            }

            time++;

        }

        return time - 1;
    }

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        burningTree obj = new burningTree();
        int ans = obj.solve(root,13);

        System.out.println(ans);
    }
}


//       1
//     /   \
//    2     3
//   / \   / \
//  4   5 6   8
