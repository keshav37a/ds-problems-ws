public class BT14_Remove_All_Leaf_Nodes {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        utility.printNodesLevelWiseUtility(rootNode);
        rootNode = removeNodes(rootNode);
        utility.printNodesLevelWiseUtility(rootNode);
    }
    public static BinaryTreeNode<Integer> removeNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return null;
        }
        if(rootNode.left==null && rootNode.right==null)
            return null;
        
        rootNode.left = removeNodes(rootNode.left);
        rootNode.right = removeNodes(rootNode.right);

        return rootNode;
    }
}