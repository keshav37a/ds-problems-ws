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