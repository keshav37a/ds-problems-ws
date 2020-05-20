/*
Print nodes at distance k from node
Send Feedback
Given a binary tree, a node and an integer K, print nodes which are at K distance from the the given node.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 2 : Node

Line 3 : K

Output format : Answer nodes in different line

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output :
9
6

Sample Input :
44 -1 -1 
44 0
Sample Output :
44

Sample Input :
1075 -1 -1 
1075 0
Sample Output :
1075

Sample Input:
683 968 1516 -1 -1 -1 -1 
968 1
Sample Output:
683

*/

import java.util.Scanner;
import java.util.ArrayList;

public class BT23_Print_Nodes_At_Distance_K {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int nodeDataToBeTaken = sc.nextInt();
        int k = sc.nextInt();
        
        compute(rootNode, nodeDataToBeTaken, k);
    }

    /*Method-1 - (1)Find the path from the root to the element
                 (2)Return that path as an arraylist
                 (3)Call nodes at depth k from each of the nodes in the path decreasing the depth by 1 for each node
    */

    public static ArrayList<NodeWithDirection> findPath(BinaryTreeNode<Integer> rootNode, int nodeDataToBeTaken, char direction){
        if(rootNode==null){
            return null;
        }

        if(rootNode.data == nodeDataToBeTaken){
            NodeWithDirection nodeInfo = new NodeWithDirection(rootNode, ' ');
            ArrayList<NodeWithDirection> pathArr = new ArrayList<>();
            pathArr.add(nodeInfo);
            return pathArr;
        }

        ArrayList<NodeWithDirection> leftPath = findPath(rootNode.left, nodeDataToBeTaken, 'L');

        if(leftPath!=null){
            NodeWithDirection nodeInfo = new NodeWithDirection(rootNode, 'L');
            leftPath.add(nodeInfo);
            return leftPath;
        }

        ArrayList<NodeWithDirection> rightPath = findPath(rootNode.right, nodeDataToBeTaken, 'R');

        if(rightPath!=null){
            NodeWithDirection nodeInfo = new NodeWithDirection(rootNode, 'R');
            rightPath.add(nodeInfo);
            return rightPath;
        }

        return null;
    }

    public static void compute(BinaryTreeNode<Integer> rootNode, int nodeDataToBeTaken, int k){
        ArrayList<NodeWithDirection> path = findPath(rootNode, nodeDataToBeTaken, ' ');
        // System.out.println(path);

        //iterate over all the elements of the path and find nodes at decreasing k. if k becomes 0 or neg then no need to compute
        for(NodeWithDirection nodeInfo: path){
            BinaryTreeNode<Integer> node = nodeInfo.node;
            char direction = nodeInfo.direction;
            if(direction=='L'){
                printNodesAtDepthK(node, k, 'R', true);
            }
            else if(direction=='R'){
                printNodesAtDepthK(node, k, 'L', true);
            }
            else if(direction==' '){
                printNodesAtDepthK(node, k, ' ', false);
            }
            k--;
            if(k<0)
                break;
        }
    }
    public static void printNodesAtDepthK(BinaryTreeNode<Integer> rootNode, int k, char direction, boolean isInitial){
        if(rootNode==null || k<0){
            return;
        }

        if(k==0){
            System.out.println(rootNode.data);
            return;
        }

        if(isInitial==true && direction=='L')
            printNodesAtDepthK(rootNode.left, k-1, direction, false);
        else if(isInitial==true && direction=='L')
            printNodesAtDepthK(rootNode.right, k-1, direction, false);
        else{
            printNodesAtDepthK(rootNode.left, k-1, direction, false);
            printNodesAtDepthK(rootNode.right, k-1, direction, false);
        }
        
    }
}

class NodeWithDirection{
    BinaryTreeNode<Integer> node;
    char direction;

    public NodeWithDirection(BinaryTreeNode<Integer> node, char direction){
        this.node = node;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return node.data +" "+ direction;
    }
}