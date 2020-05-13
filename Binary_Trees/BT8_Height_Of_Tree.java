public class BT8_Height_Of_Tree {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> root = utility.takeInputLevelWiseUtility();
        int heightOfTree = height(root);
        System.out.println(heightOfTree);
    }
    public static int height(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

}