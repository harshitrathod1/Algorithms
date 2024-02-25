package Recursion.DynamicProgramming.DpBitmask;
/*
    Leetcode : 1986
    
    There are n tasks assigned to you. The task times are represented as an integer array 
    tasks of length n, where the ith task takes tasks[i] hours to finish. A work session is 
    when you work for at most sessionTime consecutive hours and then take a break.

    You should finish the given tasks in a way that satisfies the following conditions:

    If you start a task in a work session, you must complete it in the same work session.
    You can start a new task immediately after finishing the previous one.
    You may complete the tasks in any order.
    Given tasks and sessionTime, return the minimum number of work sessions needed to finish all the 
    tasks following the conditions above.

    The tests are generated such that sessionTime is greater than or equal to the maximum element in 
    tasks[i].
*/
class Solution {
    Integer[][] dp;
    
    int dfs(int mask,int[] tasks,int stime,int curTotal){
        int n = tasks.length;
        if(mask == (1 << n) - 1){    
            return 1;
        }
        
        if(dp[mask][curTotal] != null){
            return dp[mask][curTotal];
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            //Not Selected in curSessionTime;
            if((mask & (1 << i)) == 0){
                if(curTotal + tasks[i] <= stime){
                    int subAns = dfs((mask | (1 << i)),tasks,stime,curTotal + tasks[i]);
                    answer = Math.min(subAns,answer);   
                }else{
                    int subAns = 1 + dfs((mask | (1 << i)),tasks,stime,tasks[i]);
                    answer = Math.min(subAns,answer);
                }     
            }
        }
        
        return dp[mask][curTotal] = answer;
    }
    
    public int minSessions(int[] tasks, int sessionTime) {
        dp = new Integer[(1 << 15)][16];
        int answer = dfs(0,tasks,sessionTime,0);
        return answer;
    }
}