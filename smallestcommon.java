import java.util.*;
//smallest common number in all rows of 2 d array when all rows in array are soretd
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // Number of rows
        int m = sc.nextInt();  // Number of columns
        
        int l[][] = new int[n][m];  // Creating a 2D array with n rows and m columns
        
        // Input the elements of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                l[i][j] = sc.nextInt();
            }
        }

        int lastElement = l[0][m - 1];  // The last element in the first row
        
        // Check for common elements across all rows
        OUTER:
        for (int i = 0; i < m; i++) {
            int candidate = l[0][i];  // Pick an element from the first row
            boolean foundInAllRows = true;

            for (int j = 1; j < n; j++) {
                // If the last element in the first row is smaller than the first element of a row, break
                if (lastElement < l[j][0]) {
                    break OUTER;  // Exit the outer loop since no common element can be found
                }
                
                if (!binarySearch(l[j], candidate)) {  // Use binary search to check in other rows
                    foundInAllRows = false;
                    break;
                }
            }

            if (foundInAllRows) {  // If element is found in all rows
                System.out.println(candidate);
                return;
            }
        }

        // If no common element is found, print -1
        System.out.println(-1);
    }

    // Binary search method to find if the target exists in array 'a'
    public static boolean binarySearch(int a[], int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == target) {
                return true;  // Target found
            } else if (a[mid] < target) {
                low = mid + 1;  // Move to the right half
            } else {
                high = mid - 1;  // Move to the left half
            }
        }

        return false;  // Target not found
    }
}
