import java.util.Scanner;
public class Utility {
    public static Scanner sc = new Scanner(System.in);
    public static void main(){

    }
    public static int [] takeSizeAndInputIntArr(){
        int n =sc.nextInt();
        sc.nextLine();
        int [] arr = new int[n];
        String [] strArr = sc.nextLine().split(" ");
        for(int i=0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
