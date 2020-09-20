// n= 4

//     *
//    *** 
//   *****
//  *******

import java.util.Scanner;
public class PT00026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nSpc = n-1;
        int nStars = 1;
        for(int i=0; i<n; i++){
            int nSpcTemp = nSpc;
            int nStarsTemp = nStars;
            while(nSpcTemp>0){
                System.out.print(" ");
                nSpcTemp--;
            }
            while(nStarsTemp>0){
                System.out.print("*");
                nStarsTemp--;
            }
            System.out.println();
            nStars+=2;
            nSpc-=1;
        }
    }

}
