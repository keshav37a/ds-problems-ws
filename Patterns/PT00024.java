// n=4

// 1
// 23
// 345
// 4567


import java.util.Scanner;

public class PT00024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int num = 1;
        for (int i = 1; i <= n; i++) {
            int tempCount = count;
            int tempNum = num;
            while (tempCount > 0) {
                System.out.print(tempNum);
                tempNum++;
                tempCount--;
            }
            System.out.println();
            num = i + 1;
            count++;
        }
    }
}
