/*

Print Keypad Combinations Code
Send Feedback
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf

*/

import java.util.Scanner;
import java.util.ArrayList;

public class RC0011_Keypad {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        printKeypad(str, "");
        ArrayList<String> ans = returnKeypad(str);
        System.out.println(ans);
    }

    public static void printKeypad(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        int cNum = Character.getNumericValue(str.charAt(0));
        String letters = stringMap(cNum);
        for (int i = 0; i < letters.length(); i++) {
            char cc = letters.charAt(i);
            printKeypad(str.substring(1), ans + cc);
        }
    }

    public static ArrayList<String> returnKeypad(String str) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        ArrayList<String> result = new ArrayList<>();
        int cNum = Character.getNumericValue(str.charAt(0));
        String letters = stringMap(cNum);
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            ArrayList<String> returned = returnKeypad(str.substring(1));
            for (String l : returned) {
                String f = letter + l;
                result.add(f);
            }
        }
        return result;
    }

    public static String stringMap(int num) {
        String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        return arr[num];
    }
}