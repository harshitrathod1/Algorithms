package Recursion;

import java.util.Arrays;
import java.util.List;

public class MainClass {
    /*
          Patterns of Recursion
          1. Print all Subsequences equal to sum K
          2. Print only one Subsequence equal to sum K
          3. Count subsequences equal to sum K
    */
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.subsequences(new ArrayList<>(),Arrays.asList(1,2,3),0);
//        mainClass.subsequencesEqualToSumK(new ArrayList<>(),Arrays.asList(1,2,1),0,0,2);
//        mainClass.printOneSubsequenceEqualToK(new ArrayList<>(),Arrays.asList(1,2,1),0,0,2);
//        System.out.println(mainClass.countSubsequencesEqualToK(Arrays.asList(1,2,1),0,0,2));
        System.out.println(((int)Math.log10(43324324) + 1));
    }

    public void subsequences(List<Integer> tempArr,List<Integer> arr,int idx){
        if(idx >= arr.size()){
            System.out.println(tempArr);
            return;
        }

        subsequences(tempArr,arr,idx + 1);
        tempArr.add(arr.get(idx));
        subsequences(tempArr,arr,idx + 1);
        tempArr.remove(arr.get(idx));
    }

    public void subsequencesEqualToSumK(List<Integer> tempArr,List<Integer> arr,int idx,int sum,int K){
        if(idx >= arr.size()){
            if(sum == K){
                System.out.println(tempArr);
            }
            return;
        }

        subsequencesEqualToSumK(tempArr,arr,idx + 1,sum,K);
        tempArr.add(arr.get(idx));
        subsequencesEqualToSumK(tempArr,arr,idx + 1,sum + arr.get(idx),K);
        tempArr.remove(tempArr.size() - 1);
    }
    public Boolean printOneSubsequenceEqualToK(List<Integer> tempArr,List<Integer> arr,int idx,int sum,int K){
        if(idx >= arr.size()){
            if(sum == K){
                System.out.println(tempArr);
                return true;
            }
            return false;
        }

        if(printOneSubsequenceEqualToK(tempArr,arr,idx + 1,sum,K)) return true;
        tempArr.add(arr.get(idx));
        if(printOneSubsequenceEqualToK(tempArr,arr,idx + 1,sum + arr.get(idx),K)) return true;
        tempArr.remove(tempArr.size() - 1);

        return false;
    }
    public Integer countSubsequencesEqualToK(List<Integer> arr,int idx,int sum,int K){
        if(idx >= arr.size()){
            if(sum == K) return  1;
            return 0;
        }
        int l = countSubsequencesEqualToK(arr,idx + 1,sum,K);
        int r = countSubsequencesEqualToK(arr,idx + 1,sum + arr.get(idx),K);

        return l + r;
    }
}
