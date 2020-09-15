// n=5

// 1
// 23 
// 4567
// 89123456
// 7891234567891234

import java.util.Scanner;

public class PT00021 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int digit = 1;
        for(int i=0; i<n; i++){
            int upperLimit = (int)Math.pow(2, i);
            for(int j=0; j<upperLimit; j++){
                if(digit%10==0){
                    digit++;
                    j--;
                    continue;
                }
                    
                System.out.print(digit%10);
                digit++;
            }
            System.out.println();
        }
    }
}
