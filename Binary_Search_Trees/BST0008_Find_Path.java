/*

Find path in BST
Send Feedback
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST). Return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Path from node k to root
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output :
2
5
8

*/

import java.util.ArrayList;
import java.util.Scanner;

public class BST0008_Find_Path {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int k = sc.nextInt();
        ArrayList<Integer> path = findPath(rootNode, k);
        for(int i: path){
            System.out.print(i+" ");
        }
    }
    public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> rootNode, int k){
        if(rootNode==null)
            return null;

        if(rootNode.data==k){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(rootNode.data);
            return path;
        }

        ArrayList<Integer> leftPath = null;
        ArrayList<Integer> rightPath = null;

        if(rootNode.data>k)
            leftPath = findPath(rootNode.left, k);

        if(rootNode.data<k)
            rightPath = findPath(rootNode.right, k);

        if(leftPath!=null){
            leftPath.add(rootNode.data);
            return leftPath;
        }

        if(rightPath!=null){
            rightPath.add(rootNode.data);
            return rightPath;
        }

        return null;
    }
}