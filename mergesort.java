import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int low = 0;
        int high = n - 1;
        mergesort(a, low, high);
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
    
    public static void mergesort(int a[], int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, high, mid);
        }
    }
    
    public static int[] merge(int a[], int low, int high, int mid){
        int leftarraysize = mid - low + 1;
        int rightarraysize = high - mid;
        int leftarray[] = new int[leftarraysize];
        int rightarray[] = new int[rightarraysize];
        
        for(int i = 0; i < leftarraysize; i++){
            leftarray[i] = a[i + low];
        }
        for(int j = 0; j < rightarraysize; j++){
            rightarray[j] = a[j + mid + 1];
        }
        
        int i = 0, j = 0, k = low;
       
        while(i < leftarraysize && j < rightarraysize){
            if(leftarray[i] <= rightarray[j]){
                a[k] = leftarray[i];
                i++;
            } else {
                a[k] = rightarray[j];
                j++;
            }
            k++;
        }
       
        while(i < leftarraysize){
            a[k] = leftarray[i];
            i++;
            k++;
        }
        
        
        while(j < rightarraysize){
            a[k] = rightarray[j];
            j++;
            k++;
        }
        
        return a;
    }
}
