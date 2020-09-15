//n=7
//    1
//   123
//  12345
// 1234567
//  12345
//   123
//    1

import java.util.Scanner;

public class PT00013{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        if(n%2==0)
            n++;
        int nSpc = n/2;
        int nDigits = 1;
        for(int i=0; i<n; i++){
            int nSpcTemp = nSpc;
            int nDigitsTemp = nDigits;
            while(nSpcTemp>0){
                System.out.print(' ');
                nSpcTemp--;
            }
            for(int j=1; j<=nDigitsTemp; j++){
                System.out.print(j);
            }
            System.out.println();
            if(i<n/2){
                nSpc--;
                nDigits+=2;
            }
            else{
                nSpc++;
                nDigits-=2;
            }
        }
    }
}