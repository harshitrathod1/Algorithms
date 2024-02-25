package Recursion.DynamicProgramming.LCS;

class Solution2 {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] lcs = new int[n+1][m+1];
        
        //1. Find LCS
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i-1) == s2.charAt(j - 1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        
        String scs =  "";
        
        int i = n;
        int j = m;
        
        //Bactrack and form SCS
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                scs += s1.charAt(i-1);
                i--;
                j--;
            }else{
                if(lcs[i-1][j] > lcs[i][j-1]){
                    scs += s1.charAt(i-1);
                    i--;
                }else{
                    scs += s2.charAt(j-1);
                    j--;
                }
            }
        }
        
        while(i > 0){
            scs += s1.charAt(i-1);
            i--;
        }
        
        while(j > 0){
            scs += s2.charAt(j-1);
            j--;
        }
        
        return new StringBuffer(scs).reverse().toString();
    }
}



/*
    s1 = "AGGTAB" 
    s2 = "GXTXAYB"
    res = "AGGXTXAYB"

    Backtracking : 
        if(s1[i] == s2[j]) -> include in scs; i--; j--;
        else -> move in direction of greater among dp[i-1][j] || dp[i][j-1], include s1[i-1] || s2[j-1];

        while(i > 0) include all remaining elements.
        while(j > 0) include all remaining elements.

*/
