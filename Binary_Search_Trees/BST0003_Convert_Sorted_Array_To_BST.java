import java.util.Scanner;
public class BST0003_Convert_Sorted_Array_To_BST {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size = sc.nextInt();
        int [] arr = new int[size];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        BinaryTreeNode<Integer> rootNode = constructBST(arr, 0, arr.length-1);
        Utility utility = new Utility();
        utility.printNodesLevelWise2Utility(rootNode);
    }
    public static BinaryTreeNode<Integer> constructBST(int [] arr, int start, int end){
        if(start>end){
            return null;
        }
        if(start==end){
            int dataMid = arr[start];
            BinaryTreeNode<Integer> rootNode = new BinaryTreeNode(dataMid);
            return rootNode;
        }
        int mid = (start+end)/2;
        int dataMid = arr[mid];
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode(dataMid);
        rootNode.left = constructBST(arr, start, mid-1);
        rootNode.right = constructBST(arr, mid+1, end);
        return rootNode;
    }
}