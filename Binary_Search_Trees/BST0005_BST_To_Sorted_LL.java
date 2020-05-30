/*

BST to LL
Send Feedback
Given a BST, convert it into a sorted linked list. Return the head of LL.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Linked list elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
2 5 6 7 8 10

*/
import java.util.LinkedList;

public class BST0005_BST_To_Sorted_LL {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        LinkedListNode head = BSTToLL(rootNode).head;
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static NodeContainer BSTToLL(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return new NodeContainer(null, null);
        }
        NodeContainer leftContainer = BSTToLL(rootNode.left);
        NodeContainer rightContainer = BSTToLL(rootNode.right);

        LinkedListNode newLL = new LinkedListNode(rootNode.data);

        NodeContainer currContainer = new NodeContainer(null, null);

        if(leftContainer.head==null){
            currContainer.head = newLL;
            currContainer.tail = newLL;
        }
        if(leftContainer.head!=null){
            currContainer.head = leftContainer.head;
            currContainer.tail = leftContainer.tail;
            currContainer.tail.next = newLL;
            currContainer.tail = newLL;
        }
        if(rightContainer.head!=null){
            currContainer.tail.next = rightContainer.head;
            currContainer.tail = rightContainer.tail;
        }
        return currContainer;
    }
}

class NodeContainer{
    LinkedListNode head;
    LinkedListNode tail;
    public NodeContainer(LinkedListNode head, LinkedListNode tail){
        this.head = head;
        this.tail = tail;
    }
}

class LinkedListNode{
    int data;
    LinkedListNode next;
    public LinkedListNode(int data){
        this.data = data;
    }
}