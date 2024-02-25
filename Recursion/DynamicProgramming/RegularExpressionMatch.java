package Recursion.DynamicProgramming;

class Solution {
        Boolean[][] dp;
        boolean regexMatch(char[] s,char[] p,int i,int j){
            if(i >= s.length && j >= p.length){
                return true;
            }    
            if(j >= p.length) return false;
           
            if(i < s.length && dp[i][j] != null) return dp[i][j];
            
            boolean match = ((i < s.length) && ((s[i] == p[j]) || p[j] == '.'));
                
            if(j < p.length - 1 && (p[j + 1] == '*')){
                return dp[i][j] = regexMatch(s,p,i,j+2) || (match && regexMatch(s,p,i+1,j));
            }
            
            if(match){
                return dp[i][j] = regexMatch(s,p,i+1,j+1);
            }
            
            return dp[i][j] =  false;
        }
        public boolean isMatch(String s, String p) {
            dp = new Boolean[s.length() + 1][p.length() + 1];
            return regexMatch(s.toCharArray(),p.toCharArray(),0,0);    
        }
}


/*
    "aab" ,"c*a*b"

             "c"
            /   \
           " "   "c"
            |
           "a"
           / \   \    
          ""  "a" "aa"
                    |
                   "aab"

*/