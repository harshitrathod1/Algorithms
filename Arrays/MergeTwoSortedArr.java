package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArr {

    private void swap(int[] nums1,int[] nums2,int a,int b){
        int temp = nums1[a];
        nums1[a] = nums2[b];
        nums2[b] = temp;
    }
    private void swap(int[] nums1,int a,int b){
        int temp = nums1[a];
        nums1[a] = nums1[b];
        nums1[b] = temp;
    }
    private void insert(int[] nums2,int rp){
        int M = nums2.length;
        int it = 0;
        while(it < M){
            if(nums2[it] < nums2[rp]){
                swap(nums2,rp,it);
                rp++;
            }
            it++;
        }
    }
    public void merge(int[] nums1,int[] nums2){
        int N = nums1.length;
        int M = nums2.length;
        int lp = 0;
        int rp = 0;

        while(lp < N){
            if(nums1[lp] > nums2[rp]){
                swap(nums1,nums2,lp,rp);
                insert(nums2,rp);
                lp++;
            }else{
                lp++;
            }
        }

        System.out.println(Arrays.toString(nums1)+" "+Arrays.toString(nums2));
    }

    public static void main(String[] args) {
        MergeTwoSortedArr msta = new MergeTwoSortedArr();
        int[] nums1 = new int[]{1,4,8,10};
        int[] nums2 = new int[]{0,2,3};
        msta.merge(nums1,nums2);
    }
}

/*
    O(N*M) O(1)
    [1,2,4,5]
    [7,8,10]

    1,2,8
*/
