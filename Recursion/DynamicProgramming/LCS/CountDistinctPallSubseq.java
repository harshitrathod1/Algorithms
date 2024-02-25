package Recursion.DynamicProgramming.LCS;
import java.util.*;

public class CountDistinctPallSubseq {

    public  static int countPalindromicSubsequences(String s) {
        int n = s.length();
        
        if(n == 0) return 0;
        
        int[] next = new int[n];
        int[] prev = new int[n];
        
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(map.get(ch) == null){
                prev[i] = -1;        
            }else{
                prev[i] = map.get(ch);
            }
            
            map.put(ch,i);
        }
        
        map.clear();
        
        for(int i = n-1;i >=0;i--){
            char ch = s.charAt(i);
            if(map.get(ch) == null){
                next[i] = -1;
            }else{
                next[i] = map.get(ch);
            }
            
            map.put(ch,i);
        }
        
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(prev));
        
        
        int[][] dp = new int[n][n];
        
        for(int g = 0;g < n;g++){
            for(int i = 0,j = g;j < n;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                }else if(g == 1){
                    dp[i][j] = 2;
                }else{
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    
                    if(c1 != c2){
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }else{
                        int nextpos = next[i];
                        int prevpos = prev[i];
                        
                        //a...a...a
                        if(nextpos == prevpos){
                            dp[i][j] = 2 * dp[i+1][j-1] + 1;
                        }
                        //a...a
                        else if(nextpos > prevpos){
                            dp[i][j] = 2 * dp[i+1][j-1] + 2;
                        }
                        //a...a..a...a
                        else{
                            dp[i][j] = dp[i+1][j-1] - dp[nextpos + 1][prevpos - 1] ;
                        }
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("bccb"));
    }
}
    

