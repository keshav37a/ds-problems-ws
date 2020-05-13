public class BT13_Nodes_Without_Sibling {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        printNodes(rootNode);
    }
    public static void printNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return ;
        
        if(rootNode.left==null && rootNode.right!=null)
            System.out.print(rootNode.right.data+" ");

        if(rootNode.left!=null && rootNode.right==null)
            System.out.print(rootNode.left.data+" ");

        printNodes(rootNode.left);
        printNodes(rootNode.right);
    }
}