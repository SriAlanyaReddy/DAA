//majority element that appears more thn n/2 using divide & conquer
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l[] = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }

        System.out.println(majority(l, 0, n - 1));
    }

    public static int majority(int a[], int left, int right) {
        
        if (left == right) {
            return a[left];
        }

      
        int mid = left + (right - left) / 2;
        int leftportion = majority(a, left, mid);
        int rightportion = majority(a, mid + 1, right);

        
        if (leftportion == rightportion) {
            return leftportion;
        }

       
        int leftvalcount = calculatecount(a, left, right, leftportion);
        int rightvalcount = calculatecount(a, left, right, rightportion);

       
        return leftvalcount > rightvalcount ? leftportion : rightportion;
    }

    public static int calculatecount(int a[], int left, int right, int e) {
        int count = 0;
      
        for (int i = left; i <= right; i++) {
            if (a[i] == e) {
                count++;
            }
        }
        return count;
    }
}

