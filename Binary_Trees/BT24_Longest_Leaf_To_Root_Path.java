import java.util.ArrayList;

public class BT24_Longest_Leaf_To_Root_Path {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        ArrayList<Integer> result = getPath(rootNode);
        System.out.println(result);
    }
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            ArrayList<Integer> base = new ArrayList<>();
            return base;
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> leftPathRec = getPath(rootNode.left);
        ArrayList<Integer> rightPathRec = getPath(rootNode.right);

        if(leftPathRec.size()>=rightPathRec.size()){
            leftPathRec.add(rootNode.data);
            result = leftPathRec;
        }
        else{
            rightPathRec.add(rootNode.data);
            result = rightPathRec;
        }
        return result;
    }
}