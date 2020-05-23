/* 
Binary Tree Node Update
Send Feedback
You are given a binary tree and your task is to replace the node with sum of its children nodes(if child does not exist then consider it as zero). And return its preorder.
Note : Start the updation from root.(i.e root=left child +right child) and travel level wide till the leaf nodes.
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Output format :
Updated tree in preorder.
Constraints :
1 <= N <= 10^5
Sample Input :
2 1 2 -1 -1 -1 -1
Sample Output :
3
0
0 
*/


import java.util.ArrayList;
public class BT28_Node_Update {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        ArrayList<Integer> result = getUpdatedNodes(rootNode);
        System.out.println(result);
    }
    public static ArrayList<Integer> getUpdatedNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();

        int leftSum = 0;
        int rightSum = 0;

        if(rootNode.left!=null)
            leftSum = rootNode.left.data;
        if(rootNode.right!=null)
            rightSum = rootNode.right.data;

        int totalSum = leftSum + rightSum;
        result.add(totalSum);

        ArrayList<Integer> leftArr = getUpdatedNodes(rootNode.left);
        ArrayList<Integer> rightArr = getUpdatedNodes(rootNode.right);

        for(int i: leftArr)
            result.add(i);

        for(int i: rightArr)
            result.add(i);

        return result;
    }
}