/*
xyz => x, y, z, xy, yz, xz, xyz
*/
import java.util.Scanner;
import java.util.ArrayList;
public class RC0010_Subsequences {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        ArrayList<String> ans = returnSubsequences(str);
        System.out.println(ans);
        printSubsequences(str, "");
    }
    public static ArrayList<String> returnSubsequences(String str){
        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        char cc = str.charAt(0);
        ArrayList<String> rv = returnSubsequences(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        for(String string: rv){
            String including = cc+string;
            result.add(string);
            result.add(including);
        }
        return result;
    }
    public static void printSubsequences(String str, String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        char cc = str.charAt(0);
        printSubsequences(str.substring(1), ans);
        printSubsequences(str.substring(1), ans+cc);
    }
}