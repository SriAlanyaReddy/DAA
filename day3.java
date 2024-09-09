/***Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
The operation should be performed in-place without making a copy of the array, and the time complexity should be minimized.

Constraints:
------------
nums contains only integers.
You must maintain the relative order of the non-zero elements.
The operation must be done in-place with O(1) extra space.

Input Format:
-------------
Line-1: An integer, size of the array
Line-2 to n: A single array of integers nums with at least one element.

Output Format:
-------------
Line-1: The modified input array nums, where all zeros are moved to the end while maintaining the relative order of the non-zero elements.

Sample Input-1:
----------------
5
0 1 0 3 12

Sample Output-1:
----------------
1 3 12 0 0

Sample Input-2:
---------------
1
0

Sample Output-2:
-----------------
0***/
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        
        movezeroes(l);
        
        // Print the modified array
        for (int i = 0; i < n; i++) {
            System.out.print(l[i] + " ");
        }
    }

    public static void movezeroes(int[] l) {
        int nonZeroIndex = 0; // Pointer to track the position of the next non-zero element
        
        // Move non-zero elements to the front
        for (int i = 0; i < l.length; i++) {
            if (l[i] != 0) {
                l[nonZeroIndex] = l[i];
                nonZeroIndex++;
            }
        }
        
        // Fill the remaining positions with zeros
        for (int i = nonZeroIndex; i < l.length; i++) {
            l[i] = 0;
        }
    }
}
