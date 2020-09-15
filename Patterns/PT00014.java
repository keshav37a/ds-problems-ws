// n=5

//            1
//          232
//        34543
//      4567654
//    567898765

import java.util.Scanner;
public class PT00014 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int nSpc = (n-1)*2;
        int nDigits = 1;
        for(int i=1; i<=n; i++){
            int nSpcTemp = nSpc;
            int nDigitsTemp = nDigits;
            int digitValTemp = i;
            while(nSpcTemp>0){
                System.out.print(" ");
                nSpcTemp--;
            }
            while(nDigitsTemp>0){
                System.out.print(digitValTemp);
                if(nDigitsTemp<=nDigits/2+1)
                    digitValTemp--;
                else
                    digitValTemp++;
                nDigitsTemp--;
            }
            System.out.println();
            nDigits+=2;
            nSpc-=2;
        }
    }
}
