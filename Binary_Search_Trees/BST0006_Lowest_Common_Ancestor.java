/*
LCA of BST
Send Feedback
Given a binary search tree and two nodes, find LCA(Lowest Common Ancestor) of the given two nodes in the BST. Read about LCA if you are having doubts about the definition.
If out of 2 nodes only one node is present, return that node.
If both are not present, return -1.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two integers, Node 1 and Node 2 (separated by space)
Output Format :
LCA
Constraints :
1 <= N <= 1000
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BST0006_Lowest_Common_Ancestor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();

        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        BinaryTreeNode<Integer> lca = getLCA(rootNode, node1, node2);
        if(lca!=null)
            System.out.print(lca.data);
        else
            System.out.print(-1);
    }

    public static BinaryTreeNode<Integer> getLCA(BinaryTreeNode<Integer> rootNode, int a, int b){
        if(rootNode==null)
            return null;

        if(rootNode.data==a || rootNode.data==b)
            return rootNode;

        if(rootNode.data<a && rootNode.data<b){
            return getLCA(rootNode.right, a, b);
        }
        else if(rootNode.data>a && rootNode.data>b){
            return getLCA(rootNode.left, a, b);
        }
        else{
            BinaryTreeNode<Integer> left = getLCA(rootNode.left, a, b);
            BinaryTreeNode<Integer> right = getLCA(rootNode.right, a, b);

            if(left==null && right!=null)
                return right;

            else if(left!=null && right==null)
                return left;

            else if(left!=null && right!=null)  
                return rootNode;
        }
        return null;
    }   
}