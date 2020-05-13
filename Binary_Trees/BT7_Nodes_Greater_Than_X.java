import java.util.Scanner;

public class BT7_Nodes_Greater_Than_X {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();   
        int x = sc.nextInt();
        int nodes = nodesGreater(rootNode, x);
        System.out.println(nodes);
    }
    public static int nodesGreater(BinaryTreeNode<Integer> rootNode, int x){
        if(rootNode==null)
            return 0;
        
        int leftNode = nodesGreater(rootNode.left, x);
        int rightNode = nodesGreater(rootNode.right, x);
        if(rootNode.data>x)
            return leftNode + rightNode + 1;
        return leftNode + rightNode;
    }

}