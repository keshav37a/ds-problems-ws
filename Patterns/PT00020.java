// n = 3

// 1   1
//  2 2
//   3
//  2 2
// 1   1
import java.util.Scanner;

public class PT00020 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 2 * n - 1;
        int nSpcLeft = 0;
        int nSpcRight = 2 * n - 2;
        int digit = 1;

        for (int i = 0; i < count; i++) {
            int nSpcLeftTemp = nSpcLeft;
            int nSpcRightTemp = nSpcRight;
            int digitTemp = digit;
            while (nSpcLeftTemp > 0) {
                System.out.print(" ");
                nSpcLeftTemp--;
            }
            System.out.print(digitTemp);

            if (i != count / 2) {
                while (nSpcRightTemp > 1) {
                    System.out.print(" ");
                    nSpcRightTemp--;
                }
                System.out.print(digitTemp);
            }
            System.out.println();
            if (i < count / 2) {
                nSpcLeft++;
                nSpcRight -= 2;
                digit++;
            } else {
                nSpcLeft--;
                nSpcRight += 2;
                digit--;
            }
        }
    }
}
