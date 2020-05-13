import java.util.Scanner;
public class BT10_Print_Nodes_At_Depth_K {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int depth = sc.nextInt();
        printNodes(rootNode, 2, 0);
    }
    public static void printNodes(BinaryTreeNode<Integer> rootNode, int depth, int currDepth){
        if(rootNode==null)
            return;
        if(currDepth==depth){
            System.out.print(rootNode.data+" ");
        }
        printNodes(rootNode.left, depth, currDepth+1);
        printNodes(rootNode.right, depth, currDepth+1);
    }
}