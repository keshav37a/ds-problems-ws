//n = 3

//   0
//  101
// 21012


import java.util.Scanner;

public class PT0011 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int countLeft = 0;
        int countRight = 0;
        int countSpc = n ;
        for(int i=0; i<=n; i++){
            int countLeftTemp = countLeft;
            int countRightTemp = countRight;
            int countSpcTemp = countSpc;

            while(countSpcTemp>0){
                System.out.print(" ");
                countSpcTemp--;
            }
            while(countLeftTemp>0){
                System.out.print(countLeftTemp);
                countLeftTemp--;
            }
            System.out.print(0);

            int cRight = 1;

            while(cRight<=countRightTemp){
                System.out.print(cRight);
                cRight++;
            }
            System.out.println();
            countLeft++;
            countSpc--;
            countRight++;
        }
    }
}
