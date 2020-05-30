import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BST0006_Lowest_Common_Ancestor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();

        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        BinaryTreeNode<Integer> lca = getLCA(rootNode, node1, node2);
        if(lca!=null)
            System.out.print(lca.data);
        else
            System.out.print(-1);
    }

    public static BinaryTreeNode<Integer> getLCA(BinaryTreeNode<Integer> rootNode, int a, int b){
        if(rootNode==null)
            return null;

        if(rootNode.data==a || rootNode.data==b)
            return rootNode;

        if(rootNode.data<a && rootNode.data<b){
            return getLCA(rootNode.right, a, b);
        }
        else if(rootNode.data>a && rootNode.data>b){
            return getLCA(rootNode.left, a, b);
        }
        else{
            BinaryTreeNode<Integer> left = getLCA(rootNode.left, a, b);
            BinaryTreeNode<Integer> right = getLCA(rootNode.right, a, b);

            if(left==null && right!=null)
                return right;

            else if(left!=null && right==null)
                return left;

            else if(left!=null && right!=null)  
                return rootNode;
        }
        return null;
    }

    
}