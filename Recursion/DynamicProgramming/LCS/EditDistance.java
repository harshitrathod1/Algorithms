package Recursion.DynamicProgramming.LCS;

public class EditDistance {

    static int minDistance(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0;i <= n;i++){
            dp[i][0] = i;
        }

        for(int j = 0;j <= m;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]; //No need of operation
                }else{
                    int insert = dp[i][j-1]; //Insert into s1
                    int delete = dp[i-1][j]; //Delete from s1
                    int replace = dp[i-1][j-1]; //Replace
                    dp[i][j] = 1 + Math.min(insert,Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }
    
}
