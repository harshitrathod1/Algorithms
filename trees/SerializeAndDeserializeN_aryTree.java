package trees;

import java.util.Stack;

public class SerializeAndDeserializeN_aryTree {

    private void serialize(Node root,StringBuilder sb){

        sb.append(root.val+" ");
        for(Node child: root.children){
            serialize(child,sb);
        }
        sb.append("null ");
    }
    public String serialize(Node root){
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public Node Deserialize(String data){
        if(data.length() == 0) return null;

        String[] arr = data.split(" ");
        Stack<Node> stack = new Stack<>();

        for(int i = 0; i < arr.length- 1;i++){
            String s = arr[i];
            if(s.equals("null")){
                Node root = stack.pop();
                stack.peek().children.add(root);
            }else{
                Node root = new Node(Integer.parseInt(s));
                stack.push(root);
            }

            return stack.pop();
        }

        return null;
    }

    public boolean check(Node root1,Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1.val != root2.val) return false;
        if(root1 == null || root2 == null) return false;

        boolean left = check(root1.left,root2.right);
        boolean right = check(root1.right,root2.right);

        return left && right;
    }

    public static void main(String[] args) {

    }
}
