import java.util.Queue;
import java.util.LinkedList;

public class BT5_Tree_Traversals {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        preOrder(rootNode);
        System.out.println("preorder");
        postOrder(rootNode);
        System.out.println("postorder");
        inOrder(rootNode);
        System.out.println("inorder");
        levelOrder(rootNode);
        System.out.println("levelorder");
    }
    public static void preOrder(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        System.out.print(rootNode.data+" ");
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        postOrder(rootNode.left);
        postOrder(rootNode.right);
        System.out.print(rootNode.data+" ");
    }

    public static void inOrder(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        postOrder(rootNode.left);
        System.out.print(rootNode.data+" ");
        postOrder(rootNode.right);
    }

    public static void levelOrder(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return;
        
        Queue<BinaryTreeNode<Integer>> printQueue = new LinkedList<>();
        if(rootNode==null)
            return;
        
        printQueue.add(rootNode);
        while(!printQueue.isEmpty()){
            BinaryTreeNode<Integer> node = printQueue.poll();
            System.out.print(node.data+" ");
            if(node.left!=null)
                printQueue.add(node.left);
            
            if(node.right!=null)
                printQueue.add(node.right);
        }
    }
}