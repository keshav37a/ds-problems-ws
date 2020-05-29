public class BST0004_Check_Is_BST {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        boolean isTrue = isBST(rootNode).isBST;
        System.out.println(isTrue);
    }

    //if rootnode>left & smaller than right child
    //if left subtree is bst
    //if right subtree is bst

    public static TreeInfo isBST(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        System.out.println(rootNode.data);
        if(rootNode.left!=null && rootNode.data<rootNode.left.data)
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, false);

        if(rootNode.right!=null && rootNode.data>rootNode.right.data)
            return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, false);

        TreeInfo left = isBST(rootNode.left);
        if(!left.isBST || rootNode.data<left.max){
            left.isBST = false;
            return left;
        }
        TreeInfo right = isBST(rootNode.right);
        if(!right.isBST || rootNode.data>right.min){
            left.isBST = false;
            return left;
        }
        int currMax = Math.max(rootNode.data, Math.max(left.max, right.max));
        int currMin = Math.min(rootNode.data, Math.min(left.min, right.min));
        left.max = currMax;
        left.min = currMin;
        left.isBST = true;
        return left;
    }
}
class TreeInfo{
    int min;
    int max;
    boolean isBST;

    public TreeInfo(int min, int max, boolean isBST){
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}