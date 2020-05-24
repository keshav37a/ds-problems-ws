/*
Inorder traversal without recursion
Send Feedback
Given a binary tree, print the inorder traversal of a given tree without using recursion.
Inorder traversal is: LeftChild Root RightChild
Input format :
Elements in the level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Inorder traversal, elements separated by space.
Sample Input:
1 2 3 4 5 -1 -1 -1 -1 -1 -1
Sample Output:
4 2 5 1 3
Explanation:
The input tree given to you is:
                        1
                      /   \
                     2     3
                    / \
                   4   5
The inorder traversal of the given tree will be :
4 2 5 1 3
*/

import java.util.Stack;
import java.util.HashMap;

public class BT29_Inorder_Traversal_Without_Recursion {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        printInorder(rootNode);
    }
    /*
        (1) Take rootNode and keep traversing left until null is encountered
        (2) Start popping one by one
        (3) Print the popped element
        (4) If the popped element has a right node then check that right nodes left till the end
    */

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