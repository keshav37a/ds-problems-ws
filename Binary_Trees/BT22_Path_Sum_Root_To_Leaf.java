/*
    Path Sum Root to Leaf
    Send Feedback
    Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number k.
    Input format :

    Line 1 : Elements in level order form (separated by space)

    (If any node does not have left or right child, take -1 in its place)

    Line 2 : k

    Output format : Print each path in new line, elements separated by space

    Sample Input 1 :
    5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
    13
    Sample Output 1 :
    5 6 2
    5 7 1
*/

import java.util.Scanner;
public class BT22_Path_Sum_Root_To_Leaf{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int k = sc.nextInt();
        printPath(rootNode, "", k);
    }
    public static void printPath(BinaryTreeNode<Integer> rootNode, String path, int sum){
        if(sum==0){
            System.out.println(path);
            return;
        }
        if(rootNode==null)
            return;

        if(rootNode.left==null && rootNode.right==null)
            printPath(rootNode.left, path+rootNode.data+" ", sum-rootNode.data);
        else{
            printPath(rootNode.left, path+rootNode.data+" ", sum-rootNode.data);
            printPath(rootNode.right, path+rootNode.data+" ", sum-rootNode.data);
        }       
    }
}