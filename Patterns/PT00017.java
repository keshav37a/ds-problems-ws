// n = 5

// 1    2   3    4   5
// 11   12  13   14  15
// 21   22  23   24  25
// 16   17  18   19  20
// 6    7    8   9   10

import java.util.Scanner;

public class PT00017 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = n;
        if(n%2!=0)
            p = n-1;
        for (int i = 1; i <= n; i += 2) {
            int k = (i - 1) * n + 1;
            for (int j = 0; j < n; j++) {
                System.out.print(k+ "  ");
                k++;
            }
            System.out.println();
        }
        for (int i = p; i >0; i -= 2) {
            int k = (i - 1) * n + 1;
            for (int j = 0; j < n; j++) {
                System.out.print(k+"  ");
                k++;
            }
            System.out.println();
        }
    }
}
