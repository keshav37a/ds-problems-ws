import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Utility {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    public static BinaryTreeNode takeInputLevelWiseUtility(){
        Queue<BinaryTreeNode<Integer>> inputQueue = new LinkedList<>();
        int rootData = sc.nextInt();
        if(rootData==-1)
            return null;
        
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
        inputQueue.add(rootNode);
        while(!inputQueue.isEmpty()){
            BinaryTreeNode<Integer> node = inputQueue.poll();
    
            int leftData = sc.nextInt();
            if(leftData!=-1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode(leftData);
                node.left = leftNode;
                inputQueue.add(leftNode);
            }
    
            int rightData = sc.nextInt();
            if(rightData!=-1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode(rightData);
                node.right = rightNode;
                inputQueue.add(rightNode);
            }
        }
        return rootNode;    
    }    
    public static void printNodesLevelWiseUtility(BinaryTreeNode<Integer> rootNode){
        Queue<BinaryTreeNode<Integer>> printQueue = new LinkedList<>();
        if(rootNode!=null){
            printQueue.add(rootNode);
            while(!printQueue.isEmpty()){
                BinaryTreeNode<Integer> node = printQueue.poll();
                System.out.print(node.data+" ");
                BinaryTreeNode<Integer> leftNode = node.left;
                BinaryTreeNode<Integer> rightNode = node.right;
                if(leftNode!=null){
                    printQueue.add(leftNode);
                }
                if(rightNode!=null){
                    printQueue.add(rightNode);
                }
            }
            System.out.println();
        }
    }
    public static void printNodesLevelWise2Utility(BinaryTreeNode<Integer> rootNode){
        Queue<BinaryTreeNode<Integer>> printQueue = new LinkedList<>();
        if(rootNode!=null){
            printQueue.add(rootNode);
            while(!printQueue.isEmpty()){
                BinaryTreeNode<Integer> node = printQueue.poll();
                System.out.print(node.data);
                BinaryTreeNode<Integer> leftNode = node.left;
                BinaryTreeNode<Integer> rightNode = node.right;
                if(leftNode!=null){
                    printQueue.add(leftNode);
                    System.out.print(" L"+leftNode.data);
                }
                if(rightNode!=null){
                    printQueue.add(rightNode);
                    System.out.print(" R"+rightNode.data);
                }
                System.out.println();
            }
        }
    }

    public static void getTreeInFormat(BinaryTreeNode<Integer> rootNode, int level, HashMap<Integer, StringBuilder> levelElementsMap){
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

        getTreeInFormat(rootNode.left, level+1, levelElementsMap);       
        getTreeInFormat(rootNode.right, level+1, levelElementsMap);       
    }

    public static void printTreeInFormat(HashMap<Integer, StringBuilder> levelElementsMap){
        for(Map.Entry<Integer, StringBuilder> entry: levelElementsMap.entrySet()){
            StringBuilder sbElements = entry.getValue();
            System.out.println(sbElements);
        }
    }
}
