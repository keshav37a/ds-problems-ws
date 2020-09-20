// N=4

// 1
// 11
// 121
// 1221

// N=5

// 1
// 11
// 121
// 1221
// 12221

import java.util.Scanner;
public class PT00023{
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int twoCount = -1;
        int oneCount = 1;
        for(int i=0; i<n; i++){
            int oneCountTemp = oneCount;
            int twoCountTemp = twoCount;
            while(oneCountTemp>1){
                System.out.print("1");
                oneCountTemp--;
            }
            while(twoCountTemp>0){
                System.out.print("2");
                twoCountTemp--;
            }
            while(oneCountTemp>0){
                System.out.print("1");
                oneCountTemp--;
            }
            System.out.println();
            twoCount++;
            oneCount = 2;
        }
	}
}
