import java.util.ArrayList;
public class BST0013_Merge_BST {
    public static void main(String[] args) {
        util();
    }

    public static void util(){
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode1 = utility.takeInputLevelWiseUtility();
        BinaryTreeNode<Integer> rootNode2 = utility.takeInputLevelWiseUtility();
        BinaryTreeNode<Integer> ans = computeAns(rootNode1, rootNode2);
        utility.printNodesLevelWise2Utility(ans);
    }

    public static BinaryTreeNode<Integer> computeAns(BinaryTreeNode<Integer> rootNode1, BinaryTreeNode<Integer> rootNode2){
        ArrayList<BinaryTreeNode<Integer>> arr1 = getArray(rootNode1);
        ArrayList<BinaryTreeNode<Integer>> arr2 = getArray(rootNode2);
        ArrayList<BinaryTreeNode<Integer>> mergedArr = mergeTwoSortedArrays(arr1, arr2);
        BinaryTreeNode<Integer> rootNode = makeBalancedBSTUsingInorder(mergedArr, 0, mergedArr.size()-1);
        return rootNode;
    }

    

    public static ArrayList<BinaryTreeNode<Integer>> mergeTwoSortedArrays(ArrayList<BinaryTreeNode<Integer>> arr1, ArrayList<BinaryTreeNode<Integer>> arr2){
        int i=0, j=0;
        while(i<arr1.size() && j<arr2.size()){
            BinaryTreeNode<Integer> node1 = arr1.get(i);
            BinaryTreeNode<Integer> node2 = arr2.get(j);
            if(node1.data<=node2.data){
                i++;
            }
            else{
                arr1.add(i, node2);
                i++;
                j++;
            }
        }   
        while(j<arr2.size()){
            arr1.add(arr2.get(j));
            j++;
        }
        for(BinaryTreeNode<Integer> node: arr1){
            System.out.print(node.data+" ");
        }
        System.out.println();
        return arr1;
    }

    public static BinaryTreeNode<Integer> makeBalancedBSTUsingInorder(ArrayList<BinaryTreeNode<Integer>> arr, int start, int end){
        if(start==end){
            return arr.get(start);
        }
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        BinaryTreeNode<Integer> rootNode = arr.get(mid);
        rootNode.left = makeBalancedBSTUsingInorder(arr, start, mid-1);
        rootNode.right = makeBalancedBSTUsingInorder(arr, mid+1, end);
        return rootNode;
    }

    public static ArrayList<BinaryTreeNode<Integer>> getArray(BinaryTreeNode<Integer> root){
        if(root==null)
            return new ArrayList<>();
        ArrayList<BinaryTreeNode<Integer>> left = getArray(root.left);
        ArrayList<BinaryTreeNode<Integer>> right = getArray(root.right);
        left.add(root);
        for(BinaryTreeNode<Integer> node: right){
            left.add(node);
        }
        return left;
    }
}