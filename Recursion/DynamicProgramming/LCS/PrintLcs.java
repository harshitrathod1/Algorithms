package Recursion.DynamicProgramming.LCS;

public class PrintLcs {
    
    static void PrintLCS(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        if(n == 0 || m == 0) return;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(str1[i - 1] == str2[j - 1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        String LcsStr = "";
        
        int i = n;
        int j = m;

        while(i > 0 && j > 0){
            if(str1[i-1] == str2[j-1]){
                LcsStr = str1[i - 1] + LcsStr;
                i--; 
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        System.out.println(LcsStr);
        
        return;
    }

    public static void main(String[] args) {
        PrintLCS("ABCDGH", "AEDFHR");
    }
}
