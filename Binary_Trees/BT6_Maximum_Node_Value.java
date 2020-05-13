public class BT6_Maximum_Node_Value{
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int node = maxNode(rootNode);
        System.out.println(node);
    }

    public static int maxNode(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return Integer.MIN_VALUE;
        
        int leftNode = maxNode(rootNode.left);
        int rightNode = maxNode(rootNode.right);
        return Math.max(rootNode.data, Math.max(leftNode, rightNode));
    }
}