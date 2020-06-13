/*

Print Subsets of Array
Send Feedback
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 

*/

import java.util.Scanner;
import java.util.ArrayList;

public class RC0015_Array_Subsets {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        printSubsets(arr, 0, new ArrayList<>());
        ArrayList<ArrayList<Integer>> finalAns = returnSubsets(arr, 0, new ArrayList<>());
        System.out.println(finalAns);
    }

    public static void printSubsets(int[] arr, int index, ArrayList<Integer> result) {
        if (index == arr.length) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        ArrayList<Integer> newResult = new ArrayList<>();
        for (int i : result) {
            newResult.add(i);
        }
        newResult.add(arr[index]);
        printSubsets(arr, index + 1, result);
        printSubsets(arr, index + 1, newResult);
    }

    public static ArrayList<ArrayList<Integer>> returnSubsets(int[] arr, int index, ArrayList<Integer> result) {
        if (index >= arr.length) {
            ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
            finalResult.add(result);
            return finalResult;
        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        ArrayList<Integer> newResult = new ArrayList<>();
        for (int i : result) {
            newResult.add(i);
        }
        newResult.add(arr[index]);
        ArrayList<ArrayList<Integer>> including = returnSubsets(arr, index + 1, newResult);
        ArrayList<ArrayList<Integer>> excluding = returnSubsets(arr, index + 1, result);
        for (ArrayList<Integer> list : including) {
            finalResult.add(list);
        }
        for (ArrayList<Integer> list : excluding) {
            finalResult.add(list);
        }
        return finalResult;
    }
}