public class BT4_Sum_Of_All_Nodes {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int sum = sumNodes(rootNode);
        System.out.println(sum);
    }
    public static int sumNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return 0;
        
        int leftSum = sumNodes(rootNode.left);
        int rightSum = sumNodes(rootNode.right);
        return leftSum + rightSum + rootNode.data;
    }

}

