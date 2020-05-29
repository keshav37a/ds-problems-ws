/*
Elements Between K1 and K2
Send Feedback
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two Integers k1 and k2
Output Format :
Required elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output :
6 7 8 10
*/
import java.util.Scanner;
public class BST0002_Elements_Between_K1_K2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        printNodes(rootNode, k1, k2);
    }
    public static void printNodes(BinaryTreeNode<Integer> rootNode, int k1, int k2){
        if(rootNode==null)
            return;
        
        if(rootNode.data>=k1 && rootNode.data<=k2){
            printNodes(rootNode.left, k1, k2);
            System.out.print(rootNode.data+ " ");
            printNodes(rootNode.right, k1, k2);
        }
        else if(rootNode.data<k1){
            printNodes(rootNode.right, k1, k2);
        }
        else if(rootNode.data>k2){
            printNodes(rootNode.left, k1, k2);
        }
    }
}