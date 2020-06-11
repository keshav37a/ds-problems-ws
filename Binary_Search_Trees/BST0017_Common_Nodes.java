/*

Common Nodes
Send Feedback
You are given with two Binary Search Trees and your task is to find the common elements.
Input format :
Line 1 :  Elements in level order form of first tree (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 :  Elements in level order form of second tree (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Print common elements(separated by space)
Note: Print the elements in ascending order.
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
10 5 12 1 6 -1 -1 -1 -1 -1 -1
Sample Output 1:
5 6 10
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 -1 6 -1 8 -1 -1
Sample Output 2:
2 6 8

*/

import java.util.ArrayList;
import java.util.HashMap;

public class BST0017_Common_Nodes {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode1 = utility.takeInputLevelWiseUtility();
        BinaryTreeNode<Integer> rootNode2 = utility.takeInputLevelWiseUtility();

        HashMap<Integer, Boolean> elMap = new HashMap<>();
        mapElements(rootNode1, elMap);
        StringBuilder ans = getCommonElements(rootNode2, elMap);
        System.out.println(ans);
    }
    public static void mapElements(BinaryTreeNode<Integer> rootNode, HashMap<Integer, Boolean> elMap){
        if(rootNode==null)
            return;
        elMap.put(rootNode.data, true);
        mapElements(rootNode.left, elMap);
        mapElements(rootNode.right, elMap);
    }

    public static StringBuilder getCommonElements(BinaryTreeNode<Integer> rootNode, HashMap<Integer, Boolean> elMap){
        if(rootNode==null)
            return new StringBuilder("");

        StringBuilder left = getCommonElements(rootNode.left, elMap);

        if(elMap.containsKey(rootNode.data))
            left.append(rootNode.data+" ");

        StringBuilder right = getCommonElements(rootNode.right, elMap);
        left.append(right);
        return left;
    }
}