package Arrays;


import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    void reverse(int[] nums,int start,int end){

        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    public int[] nextPermutation(int[] nums) {
        int N = nums.length;
        int breakIndex = N - 1;
        int i = N - 1;

        while(i > 0 && nums[i] <= nums[i-1]){
            i--;
        }

        breakIndex = i - 1;

        if(breakIndex >= 0){
            int rightIndex = 0;
            int justGreater = Integer.MAX_VALUE;
            for(int start = breakIndex + 1;start < N;start++){
                if(nums[start] > nums[breakIndex]){
                    if(nums[start] <= justGreater){
                        rightIndex = start;
                        justGreater = nums[start];
                    }

                }
            }
            swap(nums,breakIndex,rightIndex);
        }

        reverse(nums,breakIndex + 1,N - 1);

        return nums;
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] nums = new int[]{1,3,2};
        int[] ans = obj.nextPermutation(nums);
        for(int val : ans){
            System.out.print(val+" ");
        }
    }
}
