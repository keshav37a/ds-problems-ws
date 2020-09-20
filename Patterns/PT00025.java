// N = 5
//          1
//        23
//      345
//    4567
//  56789

import java.util.Scanner;
public class PT00025 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int nSpc = 2*n-1;
        int digitCount = 1;
        int digit = 1;
        for(int i=0; i<n; i++){
            int nSpcTemp = nSpc;
            int digitCountTemp = digitCount;
            digit = i+1;
            while(nSpcTemp>0){
                System.out.print(" ");
                nSpcTemp--;
            }
            while(digitCountTemp>0){
                System.out.print(digit);
                digit++;
                digitCountTemp--;
            }
            System.out.println();
            nSpc-=2;
            digitCount++;
        }
	}

}
