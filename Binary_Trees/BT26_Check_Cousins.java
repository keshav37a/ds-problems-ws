/*
Check cousins
Send Feedback
Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2 : integer value of p 
Line 3 : Integer value of q
Output format :
true or false
Constraints :
1 <= N <= 10^5
Sample Input :
5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
2 4
Sample Output :
true
*/
import java.lang.System.Logger.Level;
import java.util.HashMap;
import java.util.Scanner;

public class BT26_Check_Cousins{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int node1 = sc.nextInt();
        int node2 = sc.nextInt();
        HashMap<Integer, LevelParent> nodeParentMap = new HashMap<>();
        boolean isTrue = isCousin(rootNode, node1, node2, 0, nodeParentMap, -1);
        System.out.println(nodeParentMap);
        System.out.println(isTrue);
    }
    public static boolean isCousin(BinaryTreeNode<Integer> rootNode, int node1, int node2, int level, HashMap<Integer, LevelParent> nodeParentMap, int parent){
        if(rootNode==null)
            return false;

        if(rootNode.data==node1){
            //check if map contains node2
            if(nodeParentMap.containsKey(node2)){
                LevelParent levelParentNode2 = nodeParentMap.get(node2);
                int levelNode2 = levelParentNode2.level;
                int parentNode2 = levelParentNode2.parent;
                if(levelNode2==level && parentNode2!=parent)
                    return true;
                else
                    return false;
            }
            else{
                LevelParent levelNode1 = new LevelParent(level, parent);
                nodeParentMap.put(node1, levelNode1);
            }
        }
        else if(rootNode.data==node2){
            //check if map contains node1
            if(nodeParentMap.containsKey(node1)){
                LevelParent levelParentNode1 = nodeParentMap.get(node1);
                int levelNode1 = levelParentNode1.level;
                int parentNode1 = levelParentNode1.parent;
                if(levelNode1==level && parentNode1!=parent)
                    return true;
                else
                    return false;
            }
            else{
                LevelParent levelNode2 = new LevelParent(level, parent);
                nodeParentMap.put(node2, levelNode2);
            }
        }

        boolean left = isCousin(rootNode.left, node1, node2, level+1, nodeParentMap, rootNode.data);
        if(left)
            return left;

        boolean right = isCousin(rootNode.right, node1, node2, level+1, nodeParentMap, rootNode.data);
        if(right)
            return right;

        return false;
    }

}

class LevelParent{
    int level;
    int parent;
    public LevelParent(int level, int parent){
        this.level = level;
        this.parent = parent;
    }
}