package Recursion.DynamicProgramming.LCS;

/* 
    Problem Statement- Given two sequences, find the length 
    of longest subsequence present in both of them.
*/
public class ParentProblem {
    
    //Recursive
    // Time complexity - Worst case - O(2^N) [When no chars in both string match]
    public int LongestCommonSubsequence(String s1,String s2,int m,int n){
        if(m == 0 || n == 0) return 0;

        if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            return 1 + LongestCommonSubsequence(s1,s2,m-1,n-1);
        }

        return Math.max(LongestCommonSubsequence(s1,s2,m-1,n),LongestCommonSubsequence(s1, s2, m, n-1));
    }

    //Memoized
    // DP[M][N] 
    //Time complexity - Worst Case - O(m * n)
    //Space complexity - O(m * n) Ignoring stack space
    public int LongestCommonSubsequenceMemo(String s1,String s2,int m,int n,int[][] dp){
        if(m == 0 || n == 0) return 0;

        //If subproblem has already been solved
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] =  1 + LongestCommonSubsequenceMemo(s1, s2, m-1, n-1, dp);
        }

        return dp[m][n] =  Math.max(LongestCommonSubsequenceMemo(s1,s2,m-1,n,dp),
        LongestCommonSubsequenceMemo(s1, s2, m, n-1, dp) );
    }

    //Bottom Up
    //Time complexity - Worst Case - O(m * n)
    //Space complexity - O(m * n)
    public int LongestCommonSubsequenceBottomUp(String s1,String s2){
        int m = s1.length(); int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j -1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String[] args){
        ParentProblem obj = new ParentProblem();
        String s1 = "babad";
        String s2 = "dabab";
        int m = s1.length();
        int n = s2.length();
        // int[][] dp = new int[m+1][n+1];
        // Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.println(obj.LongestCommonSubsequence(s1, s2, m, n));
    }
}
