'''A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, return all strobogrammatic numbers that are of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
line-1: Return a list of all strobogrammatic numbers of length n. The list can be in any order.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11, 69, 88, 96]

Explanation:
-------------
All valid strobogrammatic numbers of length 2 are:
11: Rotates to 11
69: Rotates to 96
88: Rotates to 88
96: Rotates to 69

Sample Input-2:
---------------
1

Sample Output-2: 
----------------
[0, 1, 8]

Explanation:
------------
The strobogrammatic numbers of length 1 are:
0: Rotates to 0
1: Rotates to 1
8: Rotates to 8

NOTE: Print the results in sorted order to pass the testcases'''

import java.util.*;


class Solution {
    
    
    public static List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private static List<String> helper(int n, int finalLength) {
        if (n == 0) {
            return Arrays.asList("");
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }

        
        List<String> middles = helper(n - 2, finalLength);
        List<String> result = new ArrayList<>();
        
        
        for (String middle : middles) {
            if (n != finalLength) {
                result.add("0" + middle + "0");
            }
            result.add("1" + middle + "1");
            result.add("6" + middle + "9");
            result.add("8" + middle + "8");
            result.add("9" + middle + "6");
        }
        
        return result;
    }

    public static Boolean isPrime(int n){
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        List<String> l=findStrobogrammatic(n);
        Collections.sort(l);
        System.out.println(l);
        System.out.println("FIND THE NUMBER OF STOBOGRAMMATIC NUMBERS OF DIGIT N:");
        System.out.println(l.size());
        System.out.println("ENTER A NUMBER TO CHECK IF IT IS STROBOGRAMMATC PRIME:\n");
        int p=sc.nextInt();
        if(l.contains(p)){
            if(isPrime(p)){
                System.out.println("it is strobogrammatic prime number");
            }
        }
        
        else{
            System.out.println("NO IT IS NOT STOBOGRAMMATIC PRIME NUMBER");
        }
         System.out.println("List of all prime strobogrammatic numbers of length n are");
        for(int i=0;i<l.size();i++){
            Integer number=Integer.parseInt(l.get(i));
            if(isPrime(number)){
                System.out.print(l.get(i)+" ");
            }
        }
    }
}
