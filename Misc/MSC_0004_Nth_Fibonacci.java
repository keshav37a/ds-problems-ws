import java.util.Scanner;
import java.util.HashMap;

public class MSC_0004_Nth_Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ansIter = iter(n);
        int ansRec = recursive(n);
        int ansRecDp = recursiveDp(n, new HashMap<Integer, Integer>());
        int ansIterDp = iterativeDp(n);
        System.out.println(ansIterDp);
    }
    
    public static int iterativeDp(int n){
        int [] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    
    public static int recursiveDp(int n, HashMap<Integer, Integer> hmap){
        if(n==0 || n==1)
            return n;
        int num1 = 0, num2 = 0;
        if(hmap.containsKey(n-1)){
            num1 = hmap.get(n-1);
        }
        else{
            num1 = recursiveDp(n-1, hmap);
            hmap.put(n-1, num1);
        }
        if(hmap.containsKey(n-2)){
            num2 = hmap.get(n-2);
        }
        else{
            num2 = recursiveDp(n-2, hmap);
            hmap.put(n-2, num2);
        }
        return num1 + num2;
    }
    
    public static int recursive(int n){
        if(n==0 || n==1)
            return n;
        return recursive(n-1)+recursive(n-2);
    }
    
    public static int iter(int n){
        if(n==0 || n==1)
            return n;
        int num1 = 0;
        int num2 = 0;
        int num3 = 1;
        n-=1;
        while(n>0){
            num1 = num2;
            num2 = num3;
            num3 = num1+num2;
            n--;
        }
        return num3;
    }
}
