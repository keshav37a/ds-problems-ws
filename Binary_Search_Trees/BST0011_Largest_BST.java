public class BST0011_Largest_BST {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int height = largestBST(rootNode).maxHeight;
        System.out.println(height);
    }
    public static TreeInfoContainer largestBST(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return new TreeInfoContainer(0, 0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

        TreeInfoContainer leftSide = largestBST(rootNode.left);
        TreeInfoContainer rightSide = largestBST(rootNode.right);

        int currentHeight = 0;
        int maxHeight = Math.max(leftSide.maxHeight, rightSide.maxHeight);
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        boolean isBST = true;

        if(rootNode.data<leftSide.maxValue || rootNode.data>rightSide.minValue){
            isBST = false;
        }
        else{
            if(leftSide.isBST && rightSide.isBST){
                minValue = Math.min(leftSide.minValue, rootNode.data);
                maxValue = Math.max(rightSide.maxValue, rootNode.data);
                currentHeight = Math.max(leftSide.currentHeight, rightSide.currentHeight)+1;
                maxHeight = Math.max(currentHeight, maxHeight);
            }
            else if(leftSide.isBST && !rightSide.isBST){
                minValue = Math.min(leftSide.minValue, rootNode.data);
                maxValue = Math.max(leftSide.maxValue, rootNode.data);
                currentHeight = leftSide.currentHeight+1;
                maxHeight = Math.max(currentHeight, maxHeight);
            }
            else if(!leftSide.isBST && rightSide.isBST){
                minValue = Math.min(rightSide.minValue, rootNode.data);
                maxValue = Math.max(rightSide.maxValue, rootNode.data);
                currentHeight = rightSide.currentHeight+1;
                maxHeight = Math.max(currentHeight, maxHeight);
            }
            else{
                minValue = rootNode.data;
                maxValue = rootNode.data;
                currentHeight = 1;
                maxHeight = Math.max(currentHeight, maxHeight);
            }
        }
        
        if(!isBST){
            minValue = rootNode.data;
            maxValue = rootNode.data;
            currentHeight = 1;
            maxHeight = Math.max(currentHeight, maxHeight);
        }
        leftSide.minValue = minValue;
        leftSide.maxValue = maxValue;
        leftSide.currentHeight = currentHeight;
        leftSide.maxHeight = maxHeight;

        System.out.println("currentNode="+rootNode.data);
        System.out.println("minValue: " + minValue + " maxValue: " + maxValue + " currentHeight: " + currentHeight + " maxHeight: " + maxHeight);
        System.out.println();
        
        return leftSide;
    }
}

class TreeInfoContainer{
    int maxHeight;
    boolean isBST;
    int currentHeight;
    int maxValue;
    int minValue;
    public TreeInfoContainer(int currentHeight, int maxHeight, boolean isBST, int maxValue, int minValue){
        this.currentHeight = currentHeight;
        this.maxHeight = maxHeight;
        this.isBST = isBST;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}