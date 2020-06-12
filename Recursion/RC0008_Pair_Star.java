/*

Pair star
Send Feedback
Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a

*/
import java.util.Scanner;
public class RC0008_Pair_Star {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        String ans = pair(str);
        System.out.println(ans);
    }
    public static String pair(String str){
        if(str.length()==0)
            return "";

        String ans = "";
        char curr = str.charAt(0);
        char next = ' ';
        if(str.length()>=2)
            next = str.charAt(1);
        if(curr==next)
            ans += curr + "*";
        else
            ans += curr;
        String returned = pair(str.substring(1));
        return ans + returned;
    }
}