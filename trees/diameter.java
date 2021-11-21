package trees;

public class diameter {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        int diameter = getDiameter(root);

        System.out.println(diameter);
    }

    static int maxDepth(Node root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max,left+right);

        return Math.max(left,right)+1;
    }

    static int getDiameter(Node root){
        if(root == null) return 0;

        maxDepth(root);

        return max;
    }
}
