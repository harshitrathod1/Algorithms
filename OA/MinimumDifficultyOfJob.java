package OA;
import java.util.*;

public class MinimumDifficultyOfJob {

    public static int jobDifficulty(int[] jobs,int d,int i,int N,int[][] cache){
        if(cache[d][i] != -1) return cache[d][i];
        if(d == 1){
            int max = 0;
            while(i < N) max = Math.max(max,jobs[i++]);
            return max;
        }

        int maxDiffLeftSide = 0;
        int res = Integer.MAX_VALUE;

        for(int k = i;k < N - d + 1;k++){
            maxDiffLeftSide = Math.max(jobs[k],maxDiffLeftSide);
            int maxDiffRightSide = jobDifficulty(jobs,d-1,k+1,N,cache);
            res = Math.min(res,maxDiffLeftSide+maxDiffRightSide);
        }

        cache[d][i] =  res == Integer.MAX_VALUE ? -1 : res;
        return cache[d][i];
    }
    public static void main(String[] args) {
        int[] jobs = new int[]{6,5,4,3,2,1};
        int d = 2;
        int N = jobs.length;
        int[][] cache = new int[d+1][N+1];

        for(int i = 0;i <= d;i++) Arrays.fill(cache[i],-1);

        int ans = jobDifficulty(jobs,d,0,N,cache);
        System.out.println(ans);
    }
}
