/*
    Construct Tree Using Inorder and Preorder
    Send Feedback
    Given Preorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
    Note: Assume binary tree contains only unique elements.
    Input format :

    Line 1 : n (Total number of nodes in binary tree)

    Line 2 : Pre order traversal

    Line 3 : Inorder Traversal

    Output Format :

    Elements are printed level wise, each level in new line (separated by space).

    Sample Input :
    12
    1 2 3 4 15 5 6 7 8 10 9 12
    4 15 3 2 5 1 6 10 8 7 9 12
    Sample Output :
    1 
    2 6 
    3 5 7 
    4 8 9 
    15 10 12

*/

import java.util.HashMap;
import java.util.Scanner;

public class BT18_Build_Using_In_Pre {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numNodes = sc.nextInt();       
        sc.nextLine();

        String [] preStrArr = sc.nextLine().split(" ");
        String [] inStrArr = sc.nextLine().split(" ");

        int [] preArr = new int[numNodes];
        int [] inArr = new int[numNodes];

        for(int i=0; i<numNodes; i++){
            preArr[i] = Integer.parseInt(preStrArr[i]);
            inArr[i] = Integer.parseInt(inStrArr[i]);
        }

        BinaryTreeNode<Integer> rootNode = getTree(preArr, inArr, 0, preArr.length-1, 0, inArr.length-1);
        
        Utility utility = new Utility();
        HashMap<Integer, StringBuilder> levelElementsMap = new HashMap<>();
        utility.getTreeInFormat(rootNode, 0, levelElementsMap);
        utility.printTreeInFormat(levelElementsMap);
    }    

    public static BinaryTreeNode<Integer> getTree(int [] preArr, int [] inArr, int siPre, int eiPre, int siIn, int eiIn){
        if(siIn==eiIn){
            BinaryTreeNode<Integer> node = new BinaryTreeNode(inArr[siIn]);
            return node;
        }
        if(siPre==eiPre){
            BinaryTreeNode<Integer> node = new BinaryTreeNode(inArr[siPre]);
            return node;
        }
        
    	if(siPre>eiPre || siIn>eiIn)
            return null;

        //Find the root using starting el of preOrderArray
        int root = preArr[siPre];

        //Creating the BinaryTreeNode
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(root);

        //Search for the root and retrieve the index in the inOrderArray
        int rootIndexIn = -1;
        for(int i=siIn; i<=eiIn; i++){
            if(inArr[i]==root){
                rootIndexIn = i;
                break;
            }
        }

        int countGap = rootIndexIn-siIn;
        //Get the inOrder and PreOrder traversals for the left and right subtrees
        rootNode.left = getTree(preArr, inArr, siPre+1, siPre+countGap, siIn, rootIndexIn-1);
        rootNode.right = getTree(preArr, inArr, siPre+countGap+1, eiPre, rootIndexIn+1, eiIn);

        //Return the node;
        return rootNode;
    }
}