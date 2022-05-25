package DynamicProgramming.DpBitmask;
/*

Problem Statement

Let there be N workers and N jobs. Any worker can be assigned to perform any job, 
incurring some cost that may vary depending on the work-job assignment. It is required 
to perform all jobs by assigning exactly one worker to each job and exactly one job to each 
agent in such a way that the total cost of the assignment is minimized.

Input Format
Number of workers and job: N
Cost matrix C with dimension N*N where C(i,j) is the cost incurred on assigning ith Person to jth Job.

Sample Input
4

[
9 2 7 8
6 4 3 7
5 8 1 8
7 6 9 4
]

Sample Output
13

Constraints
N <= 20

____________________________________________

J1,J2,J3 ... Jn Jobs
P1,P2,p3.... Pn People

Assign Job to P1 in N ways
Assign Job to P2 in N - 1 ways
Assign Job to P3 in N - 2 ways
.. so on

Time Complexity = N * (N - 1) * (N - 2)...* 1 = O(N!)

1. Idea - Recursion

(CurJobToAssigned,PeopleSet) = ({1..N},{P1,P2..PN})

                        (1,{P1,P2..PN})
                            /       \
                (2,{P2,P3..PN}) ... (2,{P1,P3...PN})
    
    -> Obviously This recursion would have overlapping states.
    -> Considering Each permutation as a state and storing it would be heavy storage intensive task
    -> Seeing the constraints what if we represent each permutation of set through a integer.

2. Defining DP

    DP[i][mask] = where mask is integer representation of a permutation of a subset given.
                = Min cost of assigned given people by mask to i to N jobs remaining.

3. Recurrence

    dp(i,mask) = MIN { for all valid j | { C(j,i) + dp(i + 1,mask with jth bit off) } }

    Time -> O(N^2 * 2^N)
    Space -> O(N * 2^N)
*/                            

public class Problem1 {
    static int[][] cost = new int[21][21];
    static int[][] dp = new int[21][(1 << 21)];

    static int solve(int i,int mask,int n){
        if(i == n) return 0;
        
        if(dp[i][mask] != -1) return dp[i][mask];
        
        int answer = Integer.MAX_VALUE;
        for(int j = 0;j < n;j++){
            if((mask & (1 << j)) != 0){
                int curAns = cost[j][i] + solve(i + 1, (mask ^ (1 << j)), n);
                answer = Math.min(answer,curAns);
            }
        }

        return dp[i][mask] = answer;
    }
}
