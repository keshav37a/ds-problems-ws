//n=5
// E
// DE
// CDE
// BCDE
// ABCDE


import java.util.Scanner;

public class PT0007 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                System.out.print((char)(n-j+64));
            }
            System.out.println();
        }
    }    
}
