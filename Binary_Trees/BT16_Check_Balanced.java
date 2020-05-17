//A tree is said to be balanced if its right and left subtrees are balanced and difference of height between left and right subtrees is not greater than 1

public class BT16_Check_Balanced{
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        boolean isBalanced = checkBalance(rootNode).isBalanced;
        System.out.println(isBalanced);
    }

    public static IsBalanced checkBalance(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null){
            return new IsBalanced(0, true);
        }
        IsBalanced leftIsBalanced = checkBalance(rootNode.left);
        if(!leftIsBalanced.isBalanced){
            leftIsBalanced.isBalanced = false;
            return leftIsBalanced;
        }

        IsBalanced rightIsBalanced = checkBalance(rootNode.right);
        if(!rightIsBalanced.isBalanced){
            rightIsBalanced.isBalanced = false;
            return rightIsBalanced;
        }
        
        int leftHeight = leftIsBalanced.height;
        int rightHeight = rightIsBalanced.height;

        int heightDiff = Math.abs(leftHeight-rightHeight);
        if(heightDiff>1){
            leftIsBalanced.isBalanced = false;
            return leftIsBalanced;
        }

        int biggerHeight = (leftHeight>=rightHeight) ? leftHeight : rightHeight;
        leftIsBalanced.height = biggerHeight+1;
        return leftIsBalanced;
    }
}

class IsBalanced{
    int height;
    boolean isBalanced;

    public IsBalanced(int height, boolean isBalanced){
        this.height = height;
        this.isBalanced = isBalanced;
    }
}