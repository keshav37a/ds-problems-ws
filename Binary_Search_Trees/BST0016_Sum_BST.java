/*

You are given with a BST and an integer k. You need to find the sum of k smallest elements of the BST.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2:integer k
Output Format :
sum of k smallest elements

Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1:
7
Sample Input 2:
8 7 10 2 -1 9 13 -1 -1 -1 -1 -1 -1
2
Sample Output 1:
9

*/

import java.util.Scanner;
import java.util.ArrayList;

public class BST0016_Sum_BST{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Utility utility = new Utility();
        BinaryTreeNode<Integer> rootNode = utility.takeInputLevelWiseUtility();
        int k = sc.nextInt();
        ArrayList<Integer> sumArr = getSum(rootNode, k);
        int sum = 0;
        for(int i: sumArr)
            sum+=i;
        System.out.println(sum);
    }
    public static ArrayList<Integer> getSum(BinaryTreeNode<Integer> rootNode, int k){
        if(rootNode==null)
            return new ArrayList<>();

        ArrayList<Integer> left = getSum(rootNode.left, k);
        if(left.size()<k)
            left.add(rootNode.data);
        ArrayList<Integer> right = getSum(rootNode.right, k);
        int j = 0;
        for(int i: right){
            if(left.size()<k)
                left.add(i);
        }
        return left;
    }
}