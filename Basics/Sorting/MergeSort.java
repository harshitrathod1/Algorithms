package Basics.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort implements Sort{
    @Override
    public List<Integer> sort(List<Integer> arr) {
        if(arr.size() <= 1){
            return arr;
        }

        int n = arr.size();
        int breakPoint = n / 2;

        List<Integer> lSort = sort(arr.subList(0,breakPoint));
        List<Integer> rSort = sort(arr.subList(breakPoint,n));

        return merge(lSort,rSort);
    }

    private List<Integer> merge(List<Integer> lSort, List<Integer> rSort) {
        int n = lSort.size();
        int m = rSort.size();
        int i = 0;
        int j = 0;

        List<Integer> mergeArr = new ArrayList<>();

        while(i < n && j < m){
            if(lSort.get(i) < rSort.get(j)){
                mergeArr.add(lSort.get(i));
                i += 1;
            }else{
                mergeArr.add(rSort.get(j));
                j += 1;
            }
        }

        if(i < n){
            mergeArr.addAll(lSort.subList(i,n));
        }

        if(j < m){
            mergeArr.addAll(rSort.subList(j,m));
        }

        return mergeArr;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> arr = Arrays.asList(3,1,2,4,1,5,2,6,4,6,12,34,21,3,4,5,67,34,534,3242);
        System.out.println(mergeSort.sort(arr));
    }

}
