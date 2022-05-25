package DynamicProgramming.MCM;

public class EggDrop {
    
    //TLE
    //Time Complexity -> O(n * n * k)
    //Space Complexity -> O(k * n);
    int EggDropMemo(int k,int n,int[][] dp){
        if(n <= 1 || k == 1) return n;
        
        if(k == 0) return 0;

        if(dp[k][n] != -1) return dp[k][n];

        int minOps = Integer.MAX_VALUE;

        for(int f = 1;f <= n;f++){
            int eggBreaks = EggDropMemo(k - 1, f - 1, dp);
            int eggDontBreak = EggDropMemo(k, n - f, dp);

            int temp = 1 + Math.max(eggBreaks,eggDontBreak);
            
            minOps = Math.min(minOps,temp);
        }

        return minOps;
    }

    //Binary Search
    //Time -> O (n*k logn)
    //Space -> O(n * k)
    int EggDropMemo2(int k,int n,int[][] dp){
        if(n == 0 || n == 1) return n;
        if(k == 1) return n;
        
        if(dp[k][n] != -1) return dp[k][n];

        int minOps = Integer.MAX_VALUE;
        int left = 1;int right = n;

        while(left <= right){
            int floor = left + (right - left)/2;
            int eggBreaks = EggDropMemo2(k - 1, floor - 1, dp);
            int eggDontBreaks = EggDropMemo2(k, n - floor, dp);
            int temp = 1 + Math.max(eggBreaks,eggDontBreaks);

            minOps = Math.min(minOps, temp);
            
            if(eggBreaks < eggDontBreaks){
                left = floor + 1;
            }else{
                right = floor - 1;
            }
        }

        return dp[k][n] = minOps;

    }    

}

/*
    n = 6, k = 2;

    (k == 0) -> return 0;

    (k == 1 || n == 1) -> return n;

    6
    5
    4
    3
    2
    1

*/
