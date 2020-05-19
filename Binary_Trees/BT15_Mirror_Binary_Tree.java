import java.util.HashMap;
import java.util.Map;

/*

Mirror Binary Tree
Send Feedback
Mirror the given binary tree. That is, right child of every nodes should become left and left should become right.

Note : You don't need to print or return the tree, just mirror it.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output format : Elements in level order form (Every level in new line)

Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 
3 2 
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5 
6 10 
3 2 
9

*/

public class BT15_Mirror_Binary_Tree {
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        HashMap<Integer, StringBuilder> levelElementsMap = new HashMap<>();
        rootNode = mirror(rootNode);
        printInFormat(rootNode, 0, levelElementsMap);
        for(Map.Entry<Integer, StringBuilder> entry: levelElementsMap.entrySet()){
            StringBuilder sbElements = entry.getValue();
            System.out.println(sbElements);
        }
    }
    public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> rootNode){
        if(rootNode==null)
            return null;
        
        BinaryTreeNode<Integer> left = mirror(rootNode.left);
        BinaryTreeNode<Integer> right = mirror(rootNode.right);

        BinaryTreeNode<Integer> temp = rootNode.left;
        rootNode.left = right;
        rootNode.right = temp;
        
        return rootNode;
    }

    public static void printInFormat(BinaryTreeNode<Integer> rootNode, int level, HashMap<Integer, StringBuilder> levelElementsMap){
        if(rootNode==null)
            return;

        if(!levelElementsMap.containsKey(level)){
            StringBuilder elementsSb = new StringBuilder(rootNode.data+" ");
            levelElementsMap.put(level, elementsSb);
        }
        else{
            StringBuilder elementsSb = levelElementsMap.get(level);
            elementsSb.append(rootNode.data+" ");
            levelElementsMap.put(level, elementsSb);
        }

        printInFormat(rootNode.left, level+1, levelElementsMap);       
        printInFormat(rootNode.right, level+1, levelElementsMap);       
    }
}