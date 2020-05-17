//max distance between 2 nodes of a binary tree is the diameter

public class BT17_Diameter_Binary_Tree {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int diameter = getDiameter(rootNode).diameter;
        System.out.println(diameter);
    }

    public static DiameterHeight getDiameter(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return new DiameterHeight(0, 0);
        }

        DiameterHeight leftObj = getDiameter(rootNode.left);
        DiameterHeight rightObj = getDiameter(rootNode.right);

        int leftDia = leftObj.diameter;
        int rightDia = rightObj.diameter;

        int leftHeight = leftObj.height;
        int rightHeight = rightObj.height;
        int currentHeight = Math.max(leftHeight, rightHeight)+1;

        int currentDia = Math.max(leftHeight+rightHeight+1, Math.max(leftDia, rightDia));

        leftObj.height = currentHeight;
        leftObj.diameter = currentDia;
        return leftObj;
    }
}

class DiameterHeight{
    int diameter;
    int height;

    public DiameterHeight(int diameter, int height){
        this.diameter = diameter;
        this.height = height;
    }
}