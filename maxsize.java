/*Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5
*/

import java.util.*;


class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(calMaxArea(mat));
    }
    public static int calMaxArea(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        boolean visited[][]=new boolean[n][m];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && mat[i][j]==1){
                    int grpsize=dfs(visited,i,j,mat,n,m);
                    max=Math.max(grpsize,max);
                    
                }
            }
        }
        return max;
    }
    public static int dfs(boolean[][] visited,int i,int j,int mat[][],int n,int m){
        visited[i][j]=true;
        Stack<int[]>st=new Stack<>();
        st.add(new int[]{i,j});
        int dirx[]={0,1,-1,0,1,1,-1,-1};
        int diry[]={1,0,0,-1,1,-1,-1,1};
        int grpsize=1;
        while(!st.isEmpty()){
            int[] current=st.pop();
            int x=current[0];
            int y=current[1];
            for(int k=0;k<8;k++){
                int nx=dirx[k]+x;
                int ny=diry[k]+y;
                if(nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]==false && mat[nx][ny]==1){
                    st.add(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    grpsize++;
                }
            }
        }
        return grpsize;
    }
}
