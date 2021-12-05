package Arrays;

import OOPS1.A;

import java.util.ArrayList;
import java.util.List;

public class Pascals {

    public List<List<Integer>> method1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = null;

        for(int i = 0;i < numRows;i++){
            List<Integer> subList = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    subList.add(1);
                }else{
                    subList.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = subList;
            result.add(subList);
        }

        return result;
    }

    public List<List<Integer>> method2(int N) {

        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0;row < N;row++) {
            List<Integer> subList = new ArrayList<>();
            int val = 1;
            int i = row;
            for (int j = 0; j <= i; j++) {
                subList.add(val);
                val = val * (i - j) / (j + 1);
            }
            result.add(subList);
        }
        return result;
    }

    public List<Integer> gettingKthRow(int N){
        long val = 1;
        List<Integer> ans = new ArrayList<>();
        for(int r = 0;r <=N;r++){
            ans.add((int)val);
            val = val * (N - r)/(r + 1);
        }
        return ans;
    }

}
