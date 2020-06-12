import java.util.Scanner;
public class RC0006_Remove_X {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        char x = sc.nextLine().charAt(0);
        String ans = removeX(str, x);
        System.out.println(ans);
    }
    public static String removeX(String str, char x){
        if(str.length()==0)
            return "";

        String ans = "";
        String returned = "";
        char cc = str.charAt(0);
        if(cc!=x){
            ans+=cc;
        }
        returned = removeX(str.substring(1), x);
        return ans + returned;
    }    
}