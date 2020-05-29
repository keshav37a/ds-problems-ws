/*
Search In BST
Send Feedback
Given a BST and an integer k. Find if the integer k is present in given BST or not. Return the node with data k if it is present, return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Node with data k
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
2
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
(empty)
*/

import java.util.Scanner;
public class BST0001_Search_Node{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int searchNode = sc.nextInt();
        BinaryTreeNode<Integer> data = isPresent(rootNode, searchNode);
        if(data!=null)
            System.out.println(data.data);
    }
    public static BinaryTreeNode<Integer> isPresent(BinaryTreeNode<Integer> rootNode, int searchNode){
        if(rootNode==null || rootNode.data==searchNode)
            return rootNode;
        else if(rootNode.data>searchNode)
            return isPresent(rootNode.left, searchNode);
        else
            return isPresent(rootNode.right, searchNode);            
    }
}