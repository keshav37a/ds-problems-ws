/*
Vertical order
Send Feedback
Given a binary tree, print that binary tree in vertical order. Vertical order is -

Print the nodes which are at same vertical order in same line separated by space. Print different levels in different lines.
Order of different levels in different lines is not important. But in one level, print the element in pre-order format.
Input Format :
Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Output Format :
Required output in given format
Sample Input :
1 2 3 4 5 6 7 -1 8 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output :
7 
3 
4 
2 8 
1 5 6 

*/
import java.util.HashMap;
import java.util.Map;

public class BT27_Vertical_Order{
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        HashMap<Integer, StringBuilder> levelNodeMap = new HashMap<>();
        printVerticalOrder(rootNode, levelNodeMap, 0);
        // System.out.println(levelNodeMap);
        for(Map.Entry<Integer, StringBuilder> entry: levelNodeMap.entrySet()){
            StringBuilder sb = entry.getValue();
            System.out.println(sb);
        }
    }
    public static void printVerticalOrder(BinaryTreeNode<Integer> rootNode, HashMap<Integer, StringBuilder> levelNodeMap, int level){
        if(rootNode==null)
            return;

        if(!levelNodeMap.containsKey(level)){
            StringBuilder nodeSb = new StringBuilder(rootNode.data+" ");
            levelNodeMap.put(level, nodeSb);
        }
        else{
            StringBuilder nodesSb = levelNodeMap.get(level);
            nodesSb.append(rootNode.data+" ");
            levelNodeMap.replace(level, nodesSb);
        }
        printVerticalOrder(rootNode.left, levelNodeMap, level-1);
        printVerticalOrder(rootNode.right, levelNodeMap, level+1);
    }   
}