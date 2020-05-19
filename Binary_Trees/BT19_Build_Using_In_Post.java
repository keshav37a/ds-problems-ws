/*
    Construct Tree Using Inorder and PostOrder
    Send Feedback
    Given Postorder and Inorder traversal of a binary tree, create the binary tree associated with the traversals.You just need to construct the tree and return the root.
    Note: Assume binary tree contains only unique elements.
    Input format :

    Line 1 : n (Total number of nodes in binary tree)

    Line 2 : Post order traversal

    Line 3 : Inorder Traversal

    Output Format :

    Elements are printed level wise, each level in new line (separated by space).

    Sample Input :
    8
    8 4 5 2 6 7 3 1
    4 8 2 5 1 6 3 7
    Sample Output :
    1 
    2 3 
    4 5 6 7 
    8

*/

import java.util.HashMap;
import java.util.Scanner;

public class BT19_Build_Using_In_Post{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int numNodes = sc.nextInt();       
        sc.nextLine();

        String [] postStrArr = sc.nextLine().split(" ");
        String [] inStrArr = sc.nextLine().split(" ");

        int [] postArr = new int[numNodes];
        int [] inArr = new int[numNodes];

        for(int i=0; i<numNodes; i++){
            postArr[i] = Integer.parseInt(postStrArr[i]);
            inArr[i] = Integer.parseInt(inStrArr[i]);
        }
        
        BinaryTreeNode<Integer> rootNode = getTree(postArr, inArr, 0, postArr.length-1, 0, inArr.length-1);

        Utility utility = new Utility();
        HashMap<Integer, StringBuilder> levelElementsMap = new HashMap<>();
        utility.getTreeInFormat(rootNode, 0, levelElementsMap);
        utility.printTreeInFormat(levelElementsMap);

    }

    public static BinaryTreeNode<Integer> getTree(int [] postArr, int [] inArr, int siPost, int eiPost, int siIn, int eiIn){
        if(siPost>eiPost || siIn>eiIn)
            return null;

        if(siIn==eiIn)
            return new BinaryTreeNode(inArr[siIn]);
    
        if(siPost==eiPost)
            return new BinaryTreeNode(inArr[siPost]);
        
        if(siPost>eiPost || siIn>eiIn)
            return null;
    
        int rootData = postArr[eiPost];

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode(rootData);
        int rootIndexIn = -1;
        for(int i=eiIn; i>=siIn; i--){
            if(inArr[i]==rootData)
                rootIndexIn = i;
        }
        int countGap = eiPost - rootIndexIn + 1;

        rootNode.left = getTree(postArr, inArr, siPost, rootIndexIn-1, siIn, rootIndexIn-1);
        rootNode.right = getTree(postArr, inArr, eiPost-countGap, eiPost-1, rootIndexIn+1, eiIn);

        return rootNode;
    }
}