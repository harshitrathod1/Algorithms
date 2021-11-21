package trees;

public class postorder {
    /*
        Preorder   root left right
        Inorder    left root right
        PostOrder  left right root
    * */
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        postorderRec(root);
    }

    static void postorderRec(Node root){
        if(root == null) return;
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.print(root.val+" ");
    }


}
