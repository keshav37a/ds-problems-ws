//Given an integer N, print all the prime numbers that lie in the range 2 to N

//n=9

// 2
// 3
// 5
// 7

import java.util.Scanner;
public class MSC_0005_Prime_Range {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        trivialSol(n);
        eratosthenesSieve(n);
	}
    public static void eratosthenesSieve(int n){
        boolean [] primeArr = new boolean[10000];
        for(int i=2; i<=n; i++){
            if(primeArr[i]==false){
                for(int j=i*i; j<10000; j=j+i){
                    primeArr[j] = true;
                }
            }
        }
        for(int i=2; i<=n; i++){
            if(primeArr[i]==false)
                System.out.println(i);
        }
    }
    public static void trivialSol(int n){
        if(n>=2)
            System.out.println(2);
        for(int i=3; i<=n; i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }
    public static boolean isPrime(int n){
        int root = (int)(Math.sqrt(n)+1);
        for(int i=2; i<=root; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
