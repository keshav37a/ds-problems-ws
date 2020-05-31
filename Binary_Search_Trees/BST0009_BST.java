import java.util.LinkedList;
import java.util.Queue;

public class BST0009_BST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(10);
        bst.insert(4);
        bst.insert(9);
        bst.insert(14);
        bst.printTree();
        System.out.println(bst.getSize());
        System.out.println(bst.delete(10));
        bst.printTree();
        System.out.println(bst.getSize());
    }   
}

class BST{
    int size;
    BinaryTreeNode<Integer> rootNode;

    public BST(){
        this.size = 0;
        this.rootNode = null;
    }

    public void insert(int data){
        this.rootNode = insertHelper(this.rootNode, data);
        ++this.size;
    }

    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> rootNode, int data){
        if(rootNode==null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode(data);
            return newNode;
        }

        if(data>rootNode.data){
            rootNode.right = insertHelper(rootNode.right, data);
        }

        if(data<rootNode.data){
            rootNode.left = insertHelper(rootNode.left, data);
        }

        return rootNode;
    }

    public boolean isPresent(int k){
        return isPresentHelper(this.rootNode, k);
    }

    private boolean isPresentHelper(BinaryTreeNode<Integer> rootNode, int k){
        if(rootNode==null)
            return false;
        if(rootNode.data==k)
            return true;
        else if(rootNode.data>k)
            return isPresentHelper(rootNode.left, k);
        else 
            return isPresentHelper(rootNode.right, k);
    }

    public boolean delete(int k){
        DeleteInfoContainer del = deleteHelper(rootNode, k);
        if(del.isDeleted)
            --this.size;
        return del.isDeleted;
    }

    private DeleteInfoContainer deleteHelper(BinaryTreeNode<Integer> rootNode, int k){
        if(rootNode==null){
            return new DeleteInfoContainer(null, false);
        }
        if(rootNode.data==k){
            if(rootNode.left == null && rootNode.right==null){
                return new DeleteInfoContainer(null, true);
            }
            else if(rootNode.left !=null && rootNode.right==null){
                return new DeleteInfoContainer(rootNode.left, true);
            }
            else if(rootNode.left ==null && rootNode.right!=null){
                return new DeleteInfoContainer(rootNode.right, true);
            }
            else{
                //findsmallest on the right - delete it and replace current node data with the smallest node
                int smallestNodeOnRight = findSmallestNode(rootNode.right);
                delete(smallestNodeOnRight);
                rootNode.data = smallestNodeOnRight;
                this.size++;
                return new DeleteInfoContainer(rootNode, true);
            }
        }
        else if(rootNode.data>k){
            DeleteInfoContainer leftDelete = deleteHelper(rootNode.left, k);
            rootNode.left = leftDelete.node;
            leftDelete.node = rootNode;
            return leftDelete;
        }
        else{
            DeleteInfoContainer rightDelete = deleteHelper(rootNode.right, k);
            rootNode.right = rightDelete.node;
            rightDelete.node = rootNode;
            return rightDelete;
        }
    }

    private int findSmallestNode(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return Integer.MAX_VALUE;
        int left = findSmallestNode(rootNode.left);
        return Math.min(left, rootNode.data);
    }

    public void printTree(){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        if(this.rootNode==null){
            return;
        }
        queue.add(this.rootNode);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> node = queue.poll();
            System.out.print(node.data);
            if(node.left!=null){
                queue.add(node.left);
                System.out.print(" L:"+ node.left.data);
            }
            if(node.right!=null){
                queue.add(node.right);
                System.out.print(" R:"+node.right.data);
            }
            System.out.println();
        }
    }

    public int getSize(){
        return this.size;
    }
}

class DeleteInfoContainer{
    BinaryTreeNode<Integer> node;
    boolean isDeleted;
    public DeleteInfoContainer(BinaryTreeNode<Integer> node, boolean isDeleted){
        this.node = node;
        this.isDeleted = isDeleted;
    }
}