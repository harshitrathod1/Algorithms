package Arrays;

import java.util.ArrayList;

public class Permutations {

    public ArrayList<ArrayList<Integer>> perms = new ArrayList<>();
    //doesn't guarentee order;
    public void getPermutations(int[] nums){
        int N = nums.length;
        int[] subArr = new int[N];
        helper(nums,subArr,N,0);
    }

    private void helper(int[] nums, int[] subArr, int n,int ci) {
        if(ci >= n){
            ArrayList<Integer> subPerms = new ArrayList<>();
            for(int val : subArr){
                subPerms.add(val);
            }
            if(!perms.contains(subPerms))
                perms.add(subPerms);
            return;
        }

        for(int i = 0; i < n;i++){
            if(subArr[i] == 0) {
                subArr[i] = nums[ci];
                helper(nums,subArr,n,ci+1);
                subArr[i] = 0;
            }
        }
    }

    //maintains order
    public void getPerms(int[] nums){
        helperPerms(nums,0);
        return;
    }

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void helperPerms(int[] nums, int ci) {
        if(ci >= nums.length){
            ArrayList<Integer> subPerms = new ArrayList<>();
            for(int val : nums){
                subPerms.add(val);
            }
            perms.add(subPerms);
            return;
        }
        for(int i = ci;i < nums.length;i++){
            swap(nums,i,ci);
            helperPerms(nums,ci+1);
            swap(nums,i,ci);
        }
    }
}
