import java.util.ArrayList;

public class BT30_Inorder_Traversal_Without_Recursion_And_Stack {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        morrisTraversal(rootNode);
    }   
    
    public static void morrisTraversal(BinaryTreeNode<Integer> rootNode){
        BinaryTreeNode<Integer> currentNode = rootNode;
        while(currentNode!=null){
            if(currentNode.left!=null){
                //find rightmost element of left subtree and link it to currentnode
                BinaryTreeNode<Integer> inorderPred = currentNode.left;
                int count = 1;
                while(inorderPred.right!=null && inorderPred.right!=currentNode){
                    inorderPred = inorderPred.right;
                }
                //If there is already a link present then unlink it and move to right
                if(inorderPred.right == null){
                    inorderPred.right = currentNode;
                    currentNode = currentNode.left;
                }
                else{
                    inorderPred.right = null;
                    System.out.print(currentNode.data + " "); 
                    currentNode = currentNode.right; 
                }
            } 
            else{
                System.out.print(currentNode.data+" ");
                currentNode = currentNode.right;
            }
        }
    }
}