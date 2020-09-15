// n = 5

//   *
//  ***
// *****
//  ***
//   *

import java.util.Scanner;
public class PT00015 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int nSpc = n/2;
        int nStr = 1;
        for(int i=0; i<n; i++){
            int nSpcTemp = nSpc;
            int nStrTemp = nStr;
            while(nSpcTemp>0){
                System.out.print(" ");
                nSpcTemp--;
            }
            while(nStrTemp>0){
                System.out.print("*");
                nStrTemp--;
            }
            System.out.println();
            if(i<n/2){
                nSpc--;
                nStr+=2;
            }
            else{
                nSpc++;
                nStr-=2;
            }
        }
    }
}
