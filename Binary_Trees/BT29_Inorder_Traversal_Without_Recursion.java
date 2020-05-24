import java.util.Stack;
import java.util.HashMap;

public class BT29_Inorder_Traversal_Without_Recursion {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        printInorder(rootNode);
    }
    public static void printInorder(BinaryTreeNode<Integer> rootNode){
        Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<>();
        keepMovingLeft(rootNode, nodeStack);
        BinaryTreeNode<Integer> currentNode;
        while(!nodeStack.isEmpty()){
             currentNode = nodeStack.pop();
             System.out.print(currentNode.data+ " ");
             if(currentNode.right!=null){
                 keepMovingLeft(currentNode.right, nodeStack);
             }
        }
    }
    public static BinaryTreeNode<Integer> keepMovingLeft(BinaryTreeNode<Integer> rootNode, Stack<BinaryTreeNode<Integer>> nodeStack){
        while(rootNode!=null){
            nodeStack.push(rootNode);
            rootNode = rootNode.left;
        }
        return rootNode;
    }
}