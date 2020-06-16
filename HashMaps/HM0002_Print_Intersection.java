import java.util.HashMap;
import java.util.Scanner;

/*

Print Intersection
Send Feedback
Given two random integer arrays, print their intersection. That is, print all the elements that are present in both the given arrays.
Input arrays can contain duplicate elements.
Note : Order of elements are not important
Input format :
Line 1 : Integer N, Array 1 Size
Line 2 : Array 1 elements (separated by space)
Line 3 : Integer M, Array 2 Size
Line 4 : Array 2 elements (separated by space)
Output format :
Print intersection elements in different lines
Constraints :
0 <= M, N <= 5 * 10^7
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7 
Sample Output 1 :
2 
4 
3
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
2 
2
1

*/

public class HM0002_Print_Intersection {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        intersection(arr1, arr2);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            if (!hmap.containsKey(num)) {
                hmap.put(num, 1);
            } else {
                hmap.replace(num, hmap.get(num) + 1);
            }
        }
        for (int i : arr2) {
            if (hmap.containsKey(i) && hmap.get(i) != 0) {
                System.out.print(i + " ");
                hmap.replace(i, hmap.get(i) - 1);
            }
        }
    }
}