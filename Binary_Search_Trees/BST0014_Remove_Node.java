import java.util.Scanner;

/*
Remove node in BST
Send Feedback
Given a BST (Binary search tree) with N number of nodes and a node X (which is definitely present in the input BST). You need to remove the node X and return the root of updated BST.
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2 : Node X
Output format :
Updated BST in level order form (separated by space and each level in new line)
Constraints :
 1 <= N <= 10^3
Sample Input 1 :
5 1 10 -1 -1 -1 -1
1
Sample Output 1 :
5
10
Sample Input 2 :
15 5 20 1 10 -1 -1 -1 -1 8 -1 -1 9 -1 -1
10
Sample Output 2 :
15 
5 20 
1 8 
9
*/
public class BST0014_Remove_Node {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int node = sc.nextInt();
        rootNode = removeNodes(rootNode, node);
        utility.printNodesLevelWise2Utility(rootNode);
    }    
    public static BinaryTreeNode<Integer> removeNodes(BinaryTreeNode<Integer> rootNode, int node){
        if(rootNode==null)
            return null;
        if(rootNode.data>node)
            rootNode.left = removeNodes(rootNode.left, node);
        else if(rootNode.data<node)
            rootNode.right = removeNodes(rootNode.right, node);
        else{
            if(rootNode.left==null && rootNode.right==null)
                return null;
            else if(rootNode.left==null && rootNode.right!=null)
                return rootNode.right;
            else if(rootNode.left!=null && rootNode.right==null)
                return rootNode.left;
            else{
                //find smallest on the right
                int smallestOnRight = findSmallest(rootNode.right);
                removeNodes(rootNode, smallestOnRight);
                rootNode.data = smallestOnRight;
            }
        }
        return rootNode;
    }
    public static int findSmallest(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return Integer.MAX_VALUE;
        int left = findSmallest(rootNode.left);
        return Math.min(rootNode.data, left);
    }
}