package OA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitPrimes {

    private static final int N = 1000000;
    private int[] primes = new int[N+1];
    private List<List<Integer>> mainList;
    private List<Integer> subList;

    private void getPrimes(){
        //special cases
        primes[0] = primes[1] = 0;
        primes[2] = 1;

        //all odd numbers
        for (int i = 3;i <= N;i += 2){
            primes[i] = 1;
        }

        //check for primarility
        for (int i = 3;i <= N;i += 2){
            if(primes[i] == 1){
                for(int j = i * 2;j <= N;j += i){
                    primes[j] = 0;
                }
            }
        }
    }

    public int getNumberOfComb(String s){
        subList = new ArrayList<>();
        mainList = new ArrayList<>();
        return dfs(s,0,subList,mainList);
    }

    private int dfs(String s,int startIndex,List<Integer> subList,List<List<Integer>> mainList){
        if(startIndex >= s.length()){
            List<Integer> subListNew = new ArrayList<>(subList);
            //System.out.print(subListNew);
            mainList.add(subListNew);
            return 1;
        }

        int ans = 0;
        for(int i = startIndex;i < s.length();i++) {
            if(i + 1 - startIndex > 5) continue;
            Integer check = Integer.parseInt(s.substring(startIndex, i + 1));
            if(check > 1000000) continue;
            if (primes[check] == 1) {
                subList.add(check);
                ans += 1 * dfs(s, i + 1,subList,mainList);
                subList.remove(subList.size() - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SplitPrimes sp = new SplitPrimes();
        sp.getPrimes();

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int ans = sp.getNumberOfComb(s);
        System.out.println(ans);
        System.out.println(sp.mainList);
    }

}

/**
      a. "31173"  -> [3,11,7,3] , [3,11,73] , [31,17,3] .. 6 Ways
        31173
 **/