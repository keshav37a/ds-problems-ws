// n=3
// 333
// 233
// 123

import java.util.Scanner;

public class PT0010 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int digitCount = 0;
        int nCount = n;
        for(int i=0; i<n; i++){
            int digitCountTemp = digitCount;
            int nCountTemp = nCount;    
            while(digitCountTemp>0){
                System.out.print(n-digitCountTemp);
                digitCountTemp--;
            }
            while(nCountTemp>0){
                System.out.print(n);
                nCountTemp--;
            }
            System.out.println();
            digitCount++;
            nCount--;
        }
    }    
}
