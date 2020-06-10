import java.util.Scanner;

public class BST0015_Floor_BST {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        int value = sc.nextInt();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int ans = floor(rootNode, value);
        System.out.println(ans);
    }
    public static int floor(BinaryTreeNode<Integer> rootNode, int data){
        if(rootNode==null)
            return Integer.MAX_VALUE;

        int leftDiff = Integer.MAX_VALUE;
        int rightDiff = Integer.MAX_VALUE;

        if(rootNode.data==data)
            return data;
        else if(rootNode.data>data)
            return floor(rootNode.left, data);
        
        int right = floor(rootNode.right, data);
        return (right<=data)?right:rootNode.data;
    }
}