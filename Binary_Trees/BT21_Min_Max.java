/*
    Min and max
    Send Feedback
    Given a binary tree, find and return the min and max data value of given binary tree.
    Return the output as an object of PairAns class, which is already created.
    Input format :
    Elements in level order form (separated by space)
    (If any node does not have left or right child, take -1 in its place)
    Output Format :
    Max and min (separated by space)
    Sample Input :
    8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
    Sample Output :
    14 1
*/

public class BT21_Min_Max {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        PairAns pairAns = getMinMax(rootNode, new PairAns(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println("min: " + pairAns.min + " max: " + pairAns.max);
    }
    public static PairAns getMinMax(BinaryTreeNode<Integer> rootNode, PairAns pairAns){
        if(rootNode==null){
            return pairAns;
        }

        PairAns pairAnsLeft = getMinMax(rootNode.left, pairAns);
        PairAns pairAnsRight = getMinMax(rootNode.right, pairAns);

        pairAns.min = Math.min(rootNode.data, Math.min(pairAnsLeft.min, pairAnsRight.min));
        pairAns.max = Math.max(rootNode.data, Math.max(pairAnsLeft.max, pairAnsRight.max));

        return pairAns;
    }    
}

class PairAns 
{
	int min;
    int max;
    
    public PairAns(int min, int max){
        this.min = min;
        this.max = max;
    }
}