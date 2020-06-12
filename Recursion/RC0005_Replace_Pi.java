import java.util.Scanner;
public class RC0005_Replace_Pi {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        String ans = replace(str);
        System.out.println(ans);
    }
    public static String replace(String str){
        if(str.length()==0)
            return str;
        
        String ans = "";
        String returned = "";
        char cc = str.charAt(0);
        if(cc!='p'){
            ans+=cc;
            returned+=replace(str.substring(1));
        }
        else{
            if(str.length()>=2 && str.charAt(1)=='i'){
                ans+="3.14";
                returned+=replace(str.substring(2));
            }
            else{
                ans+=cc;
                returned+=replace(str.substring(1));
            }
        }
        return ans+returned;
    }
}