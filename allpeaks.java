import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the number of houses
        int n = sc.nextInt();
        
        // Input the heights of the houses
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // List to store all peak elements
        List<Integer> peaks = new ArrayList<>();
        
        // Find all peaks using divide and conquer
        findAllPeaks(arr, 0, n - 1, peaks);
        
        // Sort the peaks in ascending order
        Collections.sort(peaks);
        
        // Output the sorted peaks
        System.out.println(peaks);
    }
    
    // Recursive function to find all peaks using divide and conquer
    public static void findAllPeaks(int[] arr, int low, int high, List<Integer> peaks) {
        if (low > high) {
            return;
        }
        
        // Find the middle index
        int mid = low + (high - low) / 2;
        
        // Check if the middle element is a peak
        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            peaks.add(arr[mid]); // Add peak to the list
        }
        
        // Recursively search in the left and right halves
        findAllPeaks(arr, low, mid - 1, peaks);  // Search in the left half
        findAllPeaks(arr, mid + 1, high, peaks); // Search in the right half
    }
}
