// n = 5

// *****
// ** **
// *   *
// ** **
// *****

// *******
// *** ***
// **   **
// *     *
// **   **
// *** ***
// *******

import java.util.Scanner;

public class PT00019 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int nStrLeft = n/2;
        int nStrRight = n/2;
        int nSpc = -1;
        for(int i=0; i<n; i++){
            int nStrLeftTemp = nStrLeft;
            int nStrRightTemp = nStrRight;
            int nSpcTemp = nSpc;
            while(nStrLeftTemp>0){
                System.out.print("*");
                nStrLeftTemp--;
            }
            if(nSpcTemp<0){
                while(nSpcTemp<0){
                    System.out.print("*");
                    nSpcTemp++;
                }
            }
            else{
                while(nSpcTemp>0){
                    System.out.print(" ");
                    nSpcTemp--;
                }
            }
            while(nStrRightTemp>0){
                System.out.print("*");
                nStrRightTemp--;
            }
            System.out.println();
            if(i<n/2){
                nSpc+=2;
                if(i>0){
                    nStrLeft--;
                    nStrRight--;
                }
            }
            else{
                nSpc-=2;
                if(i<n-2){
                    nStrLeft++;
                    nStrRight++;
                }
            }
        }
    }    
}
