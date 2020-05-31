/*

Level wise linkedlist
Send Feedback
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Output format : Each level linked list is printed in new line (elements separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5 
6 10 
2 3 
9

*/

import java.util.ArrayList;

public class BST0010_Level_Wise_Linked_List {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        ArrayList<NodeContainer> nodeContainerList = new ArrayList<>();
        getLL(rootNode, 0, nodeContainerList);
        printNodes(nodeContainerList);
    }
    public static void getLL(BinaryTreeNode<Integer> rootNode, int level, ArrayList<NodeContainer> nodeContainerList){
        if(rootNode==null)
            return;

        LinkedListNode<BinaryTreeNode<Integer>> newNode = new LinkedListNode(rootNode);
        if(nodeContainerList.size()>level){
            NodeContainer nodeContainer = nodeContainerList.get(level);
            nodeContainer.tail.next = newNode;
            nodeContainer.tail = newNode;
        }
        else{
            NodeContainer newNodeContainer = new NodeContainer(newNode, newNode);
            nodeContainerList.add(newNodeContainer);
        }
        getLL(rootNode.left, level+1, nodeContainerList);
        getLL(rootNode.right, level+1, nodeContainerList);
    }
    public static void printNodes(ArrayList<NodeContainer> nodeContainerList){
        for(NodeContainer nodeContainer: nodeContainerList){
            LinkedListNode<BinaryTreeNode<Integer>> head = nodeContainer.head;
            while(head!=null){
                System.out.print(head.data.data+" ");
                head = head.next;
            }
            System.out.println();
        }
    }
}

class LinkedListNode<T>{
    T data;
    LinkedListNode<T> next;
    public LinkedListNode(T data){
        this.data = data;
    }
}

class NodeContainer<T>{
    LinkedListNode<T> head;
    LinkedListNode<T> tail;
    public NodeContainer(LinkedListNode<T> head, LinkedListNode<T> tail){
        this.head = head;
        this.tail = tail;
    }
}