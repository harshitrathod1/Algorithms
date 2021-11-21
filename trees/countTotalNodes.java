package trees;

public class countTotalNodes {

    /*
        Problem :- Given root of complete binary Tree , count total nodes in less than O(N)
        Time :- O(Log(n) * Log(n))
        Space :- O(1) ignore recursion stack
     */
    public static void main(String[] args) {

        Node n = new Node();
        Node root = n.getDummyTree();

        countTotalNodes obj = new countTotalNodes();
        int ans = obj.getCount(root);

        System.out.println(ans);
    }

    public int getCount(Node root){
        if(root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            return ((1 << leftHeight) - 1);
        }

        return 1 + getCount(root.left) + getCount(root.right);
    }

    private int getRightHeight(Node root) {
        if(root == null) return 0;

        int height = 1;
        while(root.right != null){
            root = root.right;
            height++;
        }
        return height;
    }

    private int getLeftHeight(Node root) {
        if(root == null) return 0;

        int height = 1;
        while(root.left != null){
            root = root.left;
            height++;
        }

        return height;
    }
}
