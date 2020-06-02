import java.util.HashMap;
import java.util.Scanner;
public class HM0001_Max_Freq_Number {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxFreq(arr));
    }
    public static int maxFreq(int [] arr){
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        int maxCount = 0;
        int value = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            int newCount = 1;
            if(!numCountMap.containsKey(num)){
                numCountMap.put(num, 1);
            }
            else{
                newCount = numCountMap.get(num)+1;
                numCountMap.put(num, newCount);
            }
            if(newCount>maxCount){
                maxCount = newCount;
                value = num;
            }
        }
        return value;
    }
}