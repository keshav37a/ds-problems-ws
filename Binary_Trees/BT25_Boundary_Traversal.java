public class BT25_Boundary_Traversal {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        compute(rootNode);
    }
    /*3 steps

    (1) Print left boundary
    (2) Print leaf nodes
    (3) Print right boundary

    */

    public static void compute(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        System.out.print(rootNode.data+" ");
        computeLeftBoundary(rootNode.left, true);
        printLeaves(rootNode);
        computeRightBoundary(rootNode.right, true);
    }

    public static void computeLeftBoundary(BinaryTreeNode<Integer> rootNode, boolean toBePrinted){
        if(rootNode==null)
            return;

        //Not printing leaf nodes here to avoid duplication
        if(rootNode.left==null && rootNode.right==null)
            toBePrinted = false;

        if(toBePrinted)
            System.out.print(rootNode.data+" ");

        if(rootNode.left!=null)
            computeLeftBoundary(rootNode.left, true);
        else if(rootNode.right!=null)
            computeLeftBoundary(rootNode.right, true);
    }

    public static void computeRightBoundary(BinaryTreeNode<Integer> rootNode, boolean toBePrinted){
        if(rootNode==null)
            return;

        //Not printing leaf nodes here to avoid duplication
        if(rootNode.left==null && rootNode.right==null)
            toBePrinted = false;
        
        if(rootNode.right!=null)
            computeRightBoundary(rootNode.right, true);
        else if(rootNode.left!=null)
            computeRightBoundary(rootNode.left, true);
        
        if(toBePrinted)
            System.out.print(rootNode.data+" ");
    }

    public static void printLeaves(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        if(rootNode.left==null && rootNode.right==null)
            System.out.print(rootNode.data+" ");

        printLeaves(rootNode.left);
        printLeaves(rootNode.right);
    }
}