import java.util.Scanner;
public class BT12_Is_Node_Present {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int element = sc.nextInt();
        System.out.println(isPresent(rootNode, element));
    }
    public static boolean isPresent(BinaryTreeNode<Integer> rootNode, int element){
        if(rootNode==null)
            return false;
        if(rootNode.data==element)
            return true;
        
        boolean left = isPresent(rootNode.left, element);
        if(left)
            return left;
        boolean right = isPresent(rootNode.right, element);
        return left || right;
    }
}