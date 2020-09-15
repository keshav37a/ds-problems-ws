// n = 4

// 4444444
// 4333334
// 4322234
// 4321234
// 4322234
// 4333334  
// 4444444

import java.util.Scanner;

public class PT00018 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 2 * n - 1;
        int dec = 0;
        int rep = count;
        int inc = 0;
        for (int i = 0; i < count; i++) {
            int decTemp = dec;
            int repTemp = rep;
            int incTemp = inc;
            int numTemp = n;
            while (decTemp > 0) {
                System.out.print(numTemp);
                numTemp--;
                decTemp--;
            }
            while (repTemp > 0) {
                System.out.print(numTemp);
                repTemp--;
            }
            while (incTemp > 0) {
                System.out.print(++numTemp);
                incTemp--;
            }
            System.out.println();
            if (i < count / 2) {
                dec++;
                inc++;
                rep -= 2;
            }
            else{
                dec--;
                inc--;
                rep += 2;
            }
        }
    }
}
