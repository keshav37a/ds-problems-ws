//n = 5
// 1 
// 3 2 
// 4 5 6 
// 10 9 8 7 
// 11 12 13 14 15

import java.util.Scanner;

public class PT0008 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 1;
        for(int i=1; i<=n; i++){
            if(i%2==1){
                for(int j=1; j<=i; j++){
                    System.out.print(count+" ");
                    count++;
                }
            }
            else{
                for(int j=i; j>=1; j--){
                    System.out.print((count+j-1)+" ");
                }
                count = count + i;
            }
            System.out.println();
        }
    }
}
