/*

Binary Search (Recursive)
Send Feedback
Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
Return -1 if x is not present in the given array.
Note : If given array size is even, take first mid.
Input format :

Line 1 : Array size

Line 2 : Array elements (separated by space)

Line 3 : x (element to be searched)

Sample Input :
6
2 3 4 5 6 8 
5 
Sample Output:
3 

*/

import java.util.Scanner;

public class RC0014_Binary_Search {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int index = binarySearch(arr, 0, arr.length - 1, num);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int si, int ei, int num) {
        if (si > ei)
            return -1;
        int mid = (si + ei) / 2;
        int curr = arr[mid];
        if (curr == num)
            return mid;
        else if (curr > num)
            return binarySearch(arr, si, mid - 1, num);
        else
            return binarySearch(arr, mid + 1, ei, num);
    }
}