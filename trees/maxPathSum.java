package trees;

public class maxPathSum {

    private static int maxPath = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        int ans = maxPathSum(root);

        System.out.println(ans);
    }

    static int helper(Node root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int leftRightMax = Math.max(left,right)+ root.val;
        int pathThroughRoot = root.val + left + right;
        int rootAlone = root.val;

        int maxAll = Math.max(leftRightMax,Math.max(pathThroughRoot,rootAlone));

        maxPath = Math.max(maxAll,maxPath);

        return Math.max(rootAlone,leftRightMax);
    }

    static int maxPathSum(Node root){
        if(root == null) return 0;

        helper(root);

        return maxPath;
    }
}
