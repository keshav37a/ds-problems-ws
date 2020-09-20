import java.util.Scanner;
import java.util.HashMap;
public class MSC_0002_Sum_Even_Odd {
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> iterObj = (HashMap<String, Integer>)usingIteration(n);
        HashMap<String, Integer> recObj = (HashMap<String, Integer>)usingRecursion(n);
        System.out.println(iterObj.get("even") + " " + iterObj.get("odd"));
        System.out.println(recObj.get("even") + " " + recObj.get("odd"));
	}
    
    public static HashMap<String, Integer> usingIteration(int n){
        int evenSum = 0, oddSum = 0;
        while(n>0){
            int rem = n%10;
            if(rem%2==0)
                evenSum+=rem;
            else
                oddSum+=rem;
            n /=10;
        }
        HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put("even", evenSum);
        hmap.put("odd", oddSum);
        return hmap;
    }
    
    public static HashMap<String, Integer> usingRecursion(int n){
        if(n==0){
            HashMap<String, Integer> hmap = new HashMap<String, Integer>();
            hmap.put("even", 0);
            hmap.put("odd", 0);
            return hmap;
        }
        HashMap<String, Integer> obj = usingRecursion(n/10);
        int rem = n%10;
        if(rem%2==0)
            obj.replace("even", obj.get("even")+rem);
        else
            obj.replace("odd", obj.get("odd")+rem);
        return obj;
    }
}
