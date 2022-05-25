package DynamicProgramming.LCS;

public class CountAllPallindromicSubstrings {

    static int countPallindromicSubstrings(String s){
        int n = s.length();
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[n + 1][n + 1];

        int count = 0;

        for(int g = 0;g < n;g++){
            for(int i = 0,j = g;j < n;i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = str[i] == str[j];
                }else{
                    if(str[i] == str[j] && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j] == true) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPallindromicSubstrings("RACECAR"));
    }
    
}
