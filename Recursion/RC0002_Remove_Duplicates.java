/*

Remove Duplicates Recursively
Send Feedback
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz

*/

import java.util.Scanner;

public class RC0002_Remove_Duplicates {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        StringBuilder ans = removeDup(str, ' ');
        System.out.println(ans);
    }

    public static StringBuilder removeDup(String str, char prev){
        if(str.length()==0)
            return new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        char cc = str.charAt(0);
        String ros = str.substring(1);
        if(cc!=prev){
            prev = cc;
            sb.append(cc);
        }
        sb.append(removeDup(ros, prev));
        return sb;
    }
}