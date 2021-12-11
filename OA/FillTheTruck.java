package OA;
import java.util.*;

public class FillTheTruck {
    public int maximumUnits(int[][] boxTypes, int T) {

        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int ans = 0;

        for(int[] box : boxTypes){
            //System.out.println(box[0]+"  "+box[1]);
            int boxes = Math.min(T,box[0]);
            ans += boxes * box[1];
            T -= boxes;
            if(T == 0) return ans;
        }

        return ans;
    }
}
