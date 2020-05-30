/*
Replace with Sum of greater nodes
Send Feedback
Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes whose data is greater than or equal to 5.
You don't need to return or print, just change the data of each node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output format : Elements are printed in level order wise, every level in new line

Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 
*/

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class BST0007_Replace_With_Sum {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        // TreeMap<Integer, BinaryTreeNode<Integer>> valueNodeMap = new TreeMap<>(Collections.reverseOrder());
        // traverse(rootNode, valueNodeMap);
        // int sum = 0;
        // for(Map.Entry<Integer, BinaryTreeNode<Integer>> entry: valueNodeMap.entrySet()){
        //     int key = entry.getKey();
        //     BinaryTreeNode<Integer> node = entry.getValue();
        //     sum+=key;
        //     node.data = sum;
        //     System.out.print(node.data+" ");
        // }
        replaceNodes(rootNode, 0);
        utility.printNodesLevelWiseUtility(rootNode);
    }

    //A better approach
    public static int replaceNodes(BinaryTreeNode<Integer> rootNode, int sum){
        if(rootNode==null)
            return 0;

        int rightSum = replaceNodes(rootNode.right, sum);
        int rootData = rootNode.data;
        int rSum = rightSum + rootData + sum;
        int leftSum = replaceNodes(rootNode.left, rSum);
        rootNode.data = rSum;
        return leftSum + rightSum + rootData;
    }

    public static void traverse(BinaryTreeNode<Integer> rootNode, TreeMap<Integer, BinaryTreeNode<Integer>> valueNodeMap){
        if(rootNode==null)
            return;

        valueNodeMap.put(rootNode.data, rootNode);
        traverse(rootNode.left, valueNodeMap);
        traverse(rootNode.right, valueNodeMap);
    }
}