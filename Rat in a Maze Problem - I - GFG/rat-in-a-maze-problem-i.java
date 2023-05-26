//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> res;
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        res=new ArrayList<>();
        helper(m,"",0,0);
        return res;
    }
    public static void helper(int[][] m, String ans, int row, int col){
        if(row==m.length-1 && col==m.length-1){
            if(!res.contains(ans)){
                res.add(ans);
            }
            return;
        }
        if(m[row][col]==0){
            return;
        }
        m[row][col]=0;
        if(row!=0){
            if(m[row-1][col]==1) {
                helper(m, ans + "U", row - 1, col);
            }
        }if(col!=0){
            if(m[row][col-1]==1) {
                helper(m, ans + "L", row, col - 1);
            }
        }if(row!=m.length-1){
            if(m[row+1][col]==1) {
                helper(m, ans + "D", row + 1, col);
            }
        }if(col!=m.length-1){
            if(m[row][col+1]==1) {
                helper(m, ans + "R", row, col + 1);
            }
        }
        m[row][col]=1;
    }
}