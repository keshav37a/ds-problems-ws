public class BT3_Count_Nodes {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int numberOfNodes = countNodes(rootNode);
        System.out.println(numberOfNodes);
    }
    public static int countNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return 0;

        int countLeft = countNodes(rootNode.left);
        int countRight = countNodes(rootNode.right);
        return countLeft+countRight+1;
    }    
}