import java.util.Scanner;
//find peak elements using divide& conquer method only
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the array size
        int n = sc.nextInt();
        
        // Input the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Find a peak element
        int peak = findPeak(arr, 0, n - 1, n);
        System.out.println("A peak element is: " + peak);
    }
    
    // Function to find peak element using divide and conquer
    public static int findPeak(int[] arr, int low, int high, int n) {
        int mid = low + (high - low) / 2;
        
        // Check if the middle element is a peak element
        if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
            return arr[mid];
        }
        // If the left neighbor is greater, move to the left half
        else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeak(arr, low, mid - 1, n);
        }
        // Else move to the right half
        else {
            return findPeak(arr, mid + 1, high, n);
        }
    }
}
