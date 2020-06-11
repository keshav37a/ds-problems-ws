import java.util.Scanner;

public class RC0003_Merge_Sort {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        displayArr(arr);
    }
    public static void displayArr(int [] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void mergeSort(int [] arr, int si, int ei){
        if(si>=ei){
            return ;
        }
        int mid = (si + ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        mergeTwoSortedArrays(arr, si, ei);
        return;
    }
    public static int [] mergeTwoSortedArrays(int [] arr, int si, int ei){
        int [] merged = new int[ei-si+1];
        int i=si, k= 0;
        int mid = (si+ei)/2;
        int j = mid+1;
        while(i<=mid && j<=ei){
            int num1 = arr[i];
            int num2 = arr[j];
            if(num1<num2){
                merged[k++] = num1;
                i++;
            }
            else if(num1>num2){
                merged[k++] = num2;
                j++;
            }
            else{
                merged[k++] = num1;
                merged[k++] = num2;
                i++;
                j++;
            }
        }
        while(i<=mid){
            merged[k++] = arr[i];
            i++;
        }
        while(j<=ei){
            merged[k++] = arr[j];
            j++;
        }
        int counter = 0;
        for(i=si; i<=ei; i++){
            arr[i] = merged[counter++];
        }
        return arr;
    }
        
}