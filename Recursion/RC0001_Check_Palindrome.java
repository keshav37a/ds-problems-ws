/*

Check Palindrome (recursive)
Send Feedback
Check whether a given String S is a palindrome using recursion. Return true or false.
Input Format :
String S
Output Format :
'true' or 'false'
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false

*/

import java.util.Scanner;
public class RC0001_Check_Palindrome {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        boolean isPalindrome = check(str, 0, str.length()-1);
        System.out.println(isPalindrome);
    }
    public static boolean check(String str, int si, int ei){
        if(si>=ei)
            return true;
        char cSi = str.charAt(si);
        char cEi = str.charAt(ei);
        if(cSi==cEi)
            return check(str, si+1, ei-1);
        return false;
    }
}