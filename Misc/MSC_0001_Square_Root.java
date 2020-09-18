// Given a number N, find its square root. You need to find and print only the integral part of square root of N.
// For eg. if number given is 18, answer is 4.

import java.util.Scanner;

public class MSC_0001_Square_Root {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = wayOne(n);
        int ansBinarySearch = binarySearch(n);
        System.out.println(ans);
        System.out.println(ansBinarySearch);
    }
    public static int binarySearch(int n){
        int left = 1, right = n;
        int root = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sq = mid * mid;
            if (sq > n) {
                right = mid-1;
            } else if (sq == n) {
                root = mid;
                break;
            } else if (sq < n) {
                left = mid+1;
                root = mid;
            }
        }
        return root;
    }
    public static int wayOne(int n){
        int root = 0;
        while(true){
            if(root*root>n){
                root-=1;
                break;
            }
            else if(root*root==n){
                break;
            }
            root++;       
        }
        return root;
    }
}
