import java.util.Scanner;

public class RC0004_Quick_Sort{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        display(arr);
    }
    public static void display(int [] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void quickSort(int [] arr, int si, int ei){
        if(si>=ei)
            return;
        int partitionIndex = partition(arr, si, ei);
        quickSort(arr, si, partitionIndex);
        quickSort(arr, partitionIndex+1, ei);
    }
    public static int partition(int [] arr, int si, int ei){
        int pivot = arr[si];
        int count = 0;
        for(int i=si+1; i<=ei; i++){
            if(arr[i]<=pivot)
                count++;
        }
        int pivotIndex = si + count;
        arr[si] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        int left = si, right = ei;
        while(left<right){
            while(arr[left]<=pivot && left<ei){
                left++;
            }
            while(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return pivotIndex;
    }
}