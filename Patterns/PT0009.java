//n=3
// ABCCBA
//  ABBA
//   AA

import java.util.Scanner;

public class PT0009 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int nSpc = 0;
        int nChars = n;
        for(int i=0; i<n; i++){
            int nSpcTemp = nSpc;
            int nCharsTemp = nChars;
            int j = 0;
            while(nSpcTemp>0){
                System.out.print(' ');
                nSpcTemp--;
            }
            while(j<nCharsTemp){
                System.out.print((char)(65+j));
                j++;
            }
            while(nCharsTemp>0){
                System.out.print((char)(65+nCharsTemp-1));
                nCharsTemp--;
            }
            System.out.println();
            nSpc++;
            nChars--;
        }
    }
}
