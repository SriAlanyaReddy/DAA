//power calculation using divide & conquer method

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int p = sc.nextInt();  
        
        
        System.out.printf("%.6f\n", powerCalculate(n, p));
    }
    
    public static float powerCalculate(int n, int p) {
        
        if (p == 0) {
            return 1;
        }
        
        
        float temp = powerCalculate(n, p/ 2);
        
       
        float result;
        
        
        if (p% 2 == 0) {
            result = temp * temp;
        }
       
        else if (p> 0) {
            result = n* temp * temp;
        }
      
        else {
            result = (temp * temp) / n;
        }
        
        return result;
    }
}
