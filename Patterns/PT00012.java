//n=7

// *
// **
// ***
// ****
// ***
// **
// *

import java.util.Scanner;

public class PT00012 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int count = 0;
        if(n%2==0)
            n++;
        for(int i=0; i<n; i++){
            for(int j=0; j<=count; j++){
                System.out.print("*");
            }
            System.out.println();
            if(i<n/2){
                count++;
            }
            else{
                count--;
            }
        }
    }
}
