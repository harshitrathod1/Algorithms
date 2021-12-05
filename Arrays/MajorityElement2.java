package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    /**
      Q. Given an array of integers find elements that occurs more than N/3 times
     Sol :- There can be at max 2 elements in array that can occur more than N/3 Times.
     If there is Majority Element than form triplets and elements that cannot form triplet called leftovers
     will be candidate for Majority Element
     **/

    public List<Integer> find(int[] nums){
        List<Integer> ans = new ArrayList<>();

        int N = nums.length;
        int count1 = 0,count2 = 0;
        int me1 = 0,me2 = 0;

        for(int val : nums){
            if(val == me1) count1++;
            else if (val == me2) count2++;
            else{
                if(count1 == 0){
                    count1 = 1;
                    me1 = val;
                }else if(count2 == 0){
                    count2 = 1;
                    me2 = val;
                }else{
                    //forming triplets
                    count1--;
                    count2--;
                }
            }
        }

        count1 = 0;
        count2 = 0;
        int frequencyRequired = N / 3;

        for(int val : nums){
            if(val == me1) count1++;
            else if (val == me2) count2++;
        }

        if(count1 > frequencyRequired) ans.add(me1);
        if(count2 > frequencyRequired) ans.add(me2);

        return ans;
    }
    public static void main(String[] args) {
        MajorityElement2 majority = new MajorityElement2();
        int[] nums1 = new int[]{1,1,2,2,3,3};
        int[] nums2 = new int[]{1,1,1,2,3,4};
        int[] nums3 = new int[]{1,1,1,2,2,2,3,4};

        System.out.println(majority.find(nums1));
        System.out.println(majority.find(nums2));
        System.out.println(majority.find(nums3));
    }
}
