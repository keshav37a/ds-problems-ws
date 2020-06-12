import java.util.Scanner;

public class RC0007_String_To_Integer {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        int ans = convert(str);
        System.out.println(ans);
    }
    public static int convert(String str){
        if(str.length()==0)
            return 0;
        int rv = convert(str.substring(1));
        int cc = Character.getNumericValue(str.charAt(0));
        int prod = cc*(int)(Math.pow(10, str.length()-1));
        return prod+rv;
    }
}