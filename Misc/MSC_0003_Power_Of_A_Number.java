import java.util.Scanner;
public class MSC_0003_Power_Of_A_Number {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        long ans = divideAndConquer(x, n);
        System.out.println(ans);
    }
    
    public static long divideAndConquer(int x, int n){
        if(n==0)
            return 1;
        else if(n==1)
            return x;
        long temp = divideAndConquer(x, n/2);
        if(n%2==0)
            return temp * temp;
        else 
            return x * temp * temp;
    }
    
    public static long wayOne(int x, int n){
        long ans = 1;
        while(n>0){
            ans*=x;
            n--;
        }
        System.out.println(ans);
        return ans;
    }
}