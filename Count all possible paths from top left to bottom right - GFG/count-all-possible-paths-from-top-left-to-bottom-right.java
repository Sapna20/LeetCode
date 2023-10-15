//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        // code here
        long[][] dp = new long[m+1][n+1];
        
        for(int i=1; i<m+1; i++) {
            dp[i][1] = 1;
        }
        
        for(int j=1; j<n+1; j++) {
            dp[1][j] = 1;
        }
        
        for(int i=2; i<m+1; i++) {
            for(int j=2; j<n+1; j++) {
                dp[i][j] = dp[i-1][j] % (long)(Math.pow(10, 9) + 7) + dp[i][j-1] % (long)(Math.pow(10, 9) + 7);
            }
        }
        
        return (dp[m][n]%(long)(Math.pow(10, 9) + 7));
    }
}