package DynamicProgramming.LCS;

public class CountAllPallindromicSubsequences {

    static int countAllSubsequences(String s){
        int n = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[n][n];
        
        for(int g = 0;g < n;g++){
            for(int i = 0,j = g;j < n;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                }else if(g == 1){
                    dp[i][j] = str[i] == str[j] ? 3 : 2;
                }else{
                    if(str[i] == str[j]){
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                    }else{
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[0][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(countAllSubsequences("AA"));
    }
}

/*
    c1 == c2 -> f(c1m) + f(mc2) + 1     ->  F(i,j-1) + F(i+1,j) + 1 
    c1 != c2 -> f(c1m) + f(mc2) - f(m)  ->  F(i,j-1) + F(i+1,j) - F(i+1,j-1)
*/
