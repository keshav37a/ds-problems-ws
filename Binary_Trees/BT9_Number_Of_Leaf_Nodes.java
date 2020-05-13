public class BT9_Number_Of_Leaf_Nodes {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int leaves = numLeaves(rootNode);
        System.out.println(leaves);
    }    

    public static int numLeaves(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return 0;
    
        int leftNode = numLeaves(rootNode.left);
        int rightNode = numLeaves(rootNode.right);
        if(rootNode.left==null && rootNode.right==null)
            return leftNode+rightNode+1;
        return leftNode+rightNode;
    }
}