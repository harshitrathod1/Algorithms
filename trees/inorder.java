package trees;

import java.util.Stack;

public class inorder {
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        inorderRec(root);
        System.out.println();
        inorderIter(root);
    }

    static void inorderRec(Node root){
        if(root == null) return;
        inorderRec(root.left);
        System.out.print(root.val+ " ");
        inorderRec(root.right);
    }

    static void inorderIter(Node root){
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else if(stack.size() > 0){
                Node c = stack.pop();
                System.out.print(c.val+" ");
                curr = c.right;
            }
        }
    }
}
