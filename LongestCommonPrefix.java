/*Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        sc.nextLine();  
        String[] s =sc.nextLine().split(" ");

       

        String ans = longestcommonprefix(s);
        System.out.println(ans);
    }

    public static boolean isCommon(String[] s, int len) {
        String prefix = s[0].substring(0, len);  
        int n = s.length;
        for (int i = 1; i < n; i++) {
            if (!s[i].startsWith(prefix)) { 
                return false;
            }
        }
        return true;
    }

    public static String longestcommonprefix(String[] s) {
        if (s == null || s.length == 0) return ""; 

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        for (String str : s) {
            minLen = Math.min(minLen, str.length());  
        }
        int high = minLen;
        String ss="";
        StringBuilder sb = new StringBuilder(ss);

        while (low <= high) {
            int mid = (low + high) / 2;  
            if (isCommon(s, mid)) {
                sb.setLength(0); 
                sb.append(s[0], 0, mid);
                low = mid + 1; 
            } else {
                high = mid - 1;  
            }
        }
        return sb.toString();
    }
}
