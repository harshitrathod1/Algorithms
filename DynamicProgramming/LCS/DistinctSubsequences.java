package DynamicProgramming.LCS;

/*
    Problem : Given two strings s and t, return the number of distinct subsequences 
    of s which equals t.

    Input: s = "rabbbit", t = "rabbit"
    Output: 3
*/

public class DistinctSubsequences {
    int bottomUp(char[] s,char[] t){
        int n = s.length;
        int m = t.length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0;i <= n;i++) dp[i][0] = 1;
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s[i-1] == t[j -1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][m];
    }

    int[][] dp;
    //Top down
    int helper(char[] s,char[] t,int i,int j){
        int n = s.length; int m = t.length;
        
        if(j == m) return 1;
        if(i == n) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s[i] == t[j]){
            return dp[i][j] = helper(s,t,i+1,j+1) + helper(s,t,i+1,j);
        }else{
            return dp[i][j] = helper(s,t,i+1,j);
        }
    }
}
