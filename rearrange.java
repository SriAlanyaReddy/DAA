/*You are given an array of integers containing both positive and negative values. 
Your task is to rearrange the array such that all negative integers appear before the positive integers while preserving the relative order of the numbers. 
The order of positive and negative integers in the array should remain unchanged, but negatives must come before positives.

Input Format:
--------------
Line-1: An integer n, the number of integers in the array.
Line-2: n integers, which are a mix of positive and negative numbers.

Output Format:
---------------
Line-1: Print the rearranged list of integers where all negative numbers come before the positive numbers while preserving the relative order.

Constraints:
------------
* 1 ≤ n ≤ 10^5 (The size of the array can be up to 100,000 integers).
* The array contains both positive and negative integers. Zero is considered as a positive number.

Sample Input-1:
---------------
8
9 -3 5 -2 -8 -6 1 3

Sample Output-1:
[-3, -2, -8, -6, 9, 5, 1, 3]


Sample Input-2:
---------------
8
5 -4 3 -4 2 1 -5 -6

Sample Output-2:
-----------------
[-4, -4, -5, -6, 5, 3, 2, 1]*/

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
       
        while(i < leftarraysize && leftarray[i]<0){
            
                a[k] = leftarray[i];
                i++;
           
                k++;
        }
        while(j<rightarraysize && rightarray[j]<0){
            a[k]=rightarray[j];
            j++;
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
