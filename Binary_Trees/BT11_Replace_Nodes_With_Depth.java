public class BT11_Replace_Nodes_With_Depth {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        replaceNodes(rootNode, 0);
    }
    public static void replaceNodes(BinaryTreeNode<Integer> rootNode, int depth){
        if(rootNode==null)
            return;

        rootNode.data = depth;
        replaceNodes(rootNode.left, depth+1);
        System.out.print(depth+" ");
        replaceNodes(rootNode.left, depth+1);
    }
}