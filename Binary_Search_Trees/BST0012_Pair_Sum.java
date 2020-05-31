/*

Pair sum in a BST
Send Feedback
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space only O(log n).
Assume BST contains all unique elements.
Note: In a pair, print the smaller element first.
Input format:

Line 1: Elements in the level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2: S

Output format: Each pair in a different line (pair elements separated by space)

Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output
2 10
5 7

*/

import java.util.HashMap;
import java.util.Scanner;
public class BST0012_Pair_Sum {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        HashMap<Integer, Integer> nodeDataMap = new HashMap<>();
        int k = sc.nextInt();
        printPairs(rootNode, k, nodeDataMap);
    }
    public static void printPairs(BinaryTreeNode<Integer> rootNode, int k, HashMap<Integer, Integer> nodeDataMap){
        if(rootNode==null)
            return;
        else if(rootNode.data>k){
            printPairs(rootNode.left, k, nodeDataMap);
        }
        else{
            if(nodeDataMap.containsKey(rootNode.data)){
                System.out.println(rootNode.data + " " + (k - rootNode.data));
            }
            else{
                int remainingNum = k - rootNode.data;
                nodeDataMap.put(remainingNum, 1);
            }
            printPairs(rootNode.left, k, nodeDataMap);
            printPairs(rootNode.right, k, nodeDataMap);
        }
    }
}
