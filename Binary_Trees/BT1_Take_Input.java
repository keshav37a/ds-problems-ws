import java.util.Scanner;

public class BT1_Take_Input {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BinaryTreeNode<Integer> rootNode = takeInput(null);
        printNodes(rootNode);
    }

    public static BinaryTreeNode<Integer> takeInput(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            System.out.println("Enter root data ");
        }
        int data = sc.nextInt();
        if(data!=-1){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            System.out.println("Enter left of " + data);
            newNode.left = takeInput(newNode);
            System.out.println("Enter right of " + data);
            newNode.right = takeInput(newNode);
            return newNode;
        }
        return null;
    }

    public static void printNodes(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return;
        }
        System.out.print(rootNode.data);
        if(rootNode.left!=null){
            System.out.print(" L"+rootNode.left.data);
        }
        if(rootNode.right!=null){
            System.out.print(" R"+rootNode.right.data);
        }
        System.out.println();
        printNodes(rootNode.left);
        printNodes(rootNode.right);
    }
}