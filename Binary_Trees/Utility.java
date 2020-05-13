import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Utility {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    public static BinaryTreeNode takeInputLevelWiseUtility(){
        Queue<BinaryTreeNode<Integer>> inputQueue = new LinkedList<>();
        int rootData = sc.nextInt();
        if(rootData==-1)
            return null;
        
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
        inputQueue.add(rootNode);
        while(!inputQueue.isEmpty()){
            BinaryTreeNode<Integer> node = inputQueue.poll();
    
            int leftData = sc.nextInt();
            if(leftData!=-1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode(leftData);
                node.left = leftNode;
                inputQueue.add(leftNode);
            }
    
            int rightData = sc.nextInt();
            if(rightData!=-1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode(rightData);
                node.right = rightNode;
                inputQueue.add(rightNode);
            }
        }
        return rootNode;    
    }    
}

