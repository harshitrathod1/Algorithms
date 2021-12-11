package OA;
import java.util.*;

public class FiveStarSellers {

    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a,int[] b) -> {
            double ratio1 = (double) (a[0] + 1) / (a[1] + 1) - (double) a[0] / a[1];
            double ratio2 = (double) (b[0] + 1) / (b[1] + 1) - (double) b[0] / b[1];
            return Double.compare(ratio2,ratio1);
        });

        for(int[] exam : classes){
            pq.offer(exam);
        }

        for(int i = 1;i <= extraStudents;i++){
            //System.out.println("Before : "+ Arrays.deepToString(pq.toArray()));
            int[] topValue = pq.poll();
            topValue[0] += 1;
            topValue[1] += 1;
            pq.offer(new int[]{topValue[0],topValue[1]});
            //System.out.println("After : "+Arrays.deepToString(pq.toArray()));
        }

        double total = 0;
        int count = 0;

        while (!pq.isEmpty()){
            int[] pop = pq.poll();
            total += (double) pop[0] / pop[1];
            count += 1;
        }

        double maxRatio = total / count;

        return maxRatio;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,4},{3,9},{4,5},{2,10}};
        double ans = maxAverageRatio(arr,4);
        System.out.println(ans);
    }
}
