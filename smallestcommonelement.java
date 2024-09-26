//find smallest common element in 2d array when all rows in array are sorted using binary search

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int l[][] = {
            {1, 2, 3, 5, 6}, 
            {5, 6, 7, 8, 9}, 
            {4, 5, 6, 9, 11}, 
            {-1, 0, 2, 5, 6}
        };

        int n = l.length;  // Number of rows in the array
        int m = l[0].length;  // Number of columns in the array

        // Iterating over the first row elements to find the smallest common element
        for (int i = 0; i < m; i++) {
            int candidate = l[0][i];  // Current element from the first row
            boolean foundInAllRows = true;

            // Check if this element exists in all other rows
            for (int j = 1; j < n; j++) {
                if (!binarySearch(l[j], candidate)) {
                    foundInAllRows = false;
                    break;  // No need to check further if it doesn't exist in one row
                }
            }

            // If the element is found in all rows, print and exit
            if (foundInAllRows) {
                System.out.println("Smallest common element: " + candidate);
                return;
            }
        }

        // If no common element is found
        System.out.println("No common element found.");
    }

    // Binary search to find if 'target' exists in the sorted array 'a[]'
    public static boolean binarySearch(int a[], int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == target) {
                return true;  // Found the element
            } else if (a[mid] < target) {
                low = mid + 1;  // Search in the right half
            } else {
                high = mid - 1;  // Search in the left half
            }
        }

        return false;  // Element not found
    }
}
