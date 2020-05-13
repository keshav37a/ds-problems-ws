import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BT2_Take_Input_Level_Wise {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BinaryTreeNode<Integer> rootNode = takeInputLevelWise();
        printNodesLevelWise(rootNode);        
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Queue<BinaryTreeNode<Integer>> inputQueue = new LinkedList<>();
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        if(rootData==-1)
            return null;
        
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
        inputQueue.add(rootNode);
        while(!inputQueue.isEmpty()){
            BinaryTreeNode<Integer> node = inputQueue.poll();

            System.out.println("Enter left of " + node.data);
            int leftData = sc.nextInt();
            if(leftData!=-1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode(leftData);
                node.left = leftNode;
                inputQueue.add(leftNode);
            }

            System.out.println("Enter right of " + node.data);
            int rightData = sc.nextInt();
            if(rightData!=-1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode(rightData);
                node.right = rightNode;
                inputQueue.add(rightNode);
            }

        }
        return rootNode;
    }

    public static void printNodesLevelWise(BinaryTreeNode<Integer> rootNode){
        Queue<BinaryTreeNode<Integer>> printQueue = new LinkedList<>();
        if(rootNode!=null){
            printQueue.add(rootNode);
            while(!printQueue.isEmpty()){
                BinaryTreeNode<Integer> node = printQueue.poll();
                System.out.print(node.data);
                BinaryTreeNode<Integer> leftNode = node.left;
                BinaryTreeNode<Integer> rightNode = node.right;
                if(leftNode!=null){
                    printQueue.add(leftNode);
                    System.out.print(" L"+leftNode.data);
                }
                if(rightNode!=null){
                    printQueue.add(rightNode);
                    System.out.print(" R"+rightNode.data);
                }
                System.out.println();
            }
        }
    }
}
