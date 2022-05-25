package DynamicProgramming.MCM;

import java.util.Arrays;

/*
    Find Most efficient way of multiplying given matrices. Return Minimum number of operations
    to multiply given set of matrices.

    arr = [40,20,30,10,30]
    min_operations = 26000
*/
public class MatrixChainMultiplication {

    //Time Complexity -> O(2^N)
    static int minOperations(int[] mat,int i,int j){
        if(i >= j) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int currentCost = mat[i-1] * mat[k] * mat[j] + minOperations(mat, i, k) 
                              + minOperations(mat, k+1, j);
            
            if(currentCost < minCost){
                minCost = currentCost;
            }
        }

        return minCost;
    }

    //O(N^3)
    static int MatrixChainMultiplicationMemo(int[] mat,int i,int j,int[][] dp){
        if(i == j) return 0;

        //Overlapping Subproblems
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k < j;k++){
            int subAns = mat[i-1] * mat[k] * mat[j] + MatrixChainMultiplicationMemo(mat, i, k,dp) + 
            MatrixChainMultiplicationMemo(mat, k+1, j, dp);
            
            dp[i][j] = Math.min(dp[i][j],subAns);
        }

        return dp[i][j];
    }

    
    public static void main(String[] args) {
        int[] mat = {40,20,30,10,30};
        int n = mat.length;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        int ans = MatrixChainMultiplicationMemo(mat, 1, n - 1,dp);
    
        System.out.println(ans);
    }
}
