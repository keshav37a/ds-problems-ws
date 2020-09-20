
//N=4
// 1
// 11
// 202
// 3003

//N=5
// 1
// 11
// 202
// 3003
// 40004

import java.util.Scanner;
public class PT00022 {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zeroCount = -1;
        int rightNumCount = 0;
        for(int i=0; i<n; i++){
            int zeroCountTemp = zeroCount;
            int boundaryDigit = 1;
            if(zeroCount<=0)
            	boundaryDigit = 1;
            else
                boundaryDigit = i;
            
            System.out.print(boundaryDigit);
            
            while(zeroCountTemp>0){
                System.out.print("0");
                zeroCountTemp--;
            }
            
            if(rightNumCount>0){
                 System.out.print(boundaryDigit);
            }
            
            System.out.println();
            zeroCount++;
            rightNumCount=1;
        }
	}
}
