package Recursion.DynamicProgramming.LCS;
/*
    Finding Longest Common Substring is trickier than Longest common subsequence. In this what we 
    have to do is find , for all prefixes of s1 and s2 find longest common suffix between them.

    for Ex: - "ABCSXM" and "FGBCSER", the LCSs = "BCS", Now this would be found in
    prefixes "ABCS" and "FGBCS".

    At a particular point if C1 == C2, we look back and find longest common substring till that point.

*/

public class LongestCommonSubstring {
    
    int LongestCommonSubstringBottomUp(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        int maxLen =  0;

        for(int i = 1;i <= n;i++){
            int c1 = s1.charAt(i);
            for(int j = 1;j <= m;j++){
                int c2 = s2.charAt(j);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1]  + 1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "ABCSDE";
        System.out.println(s1.substring(1,4));
    }
}
