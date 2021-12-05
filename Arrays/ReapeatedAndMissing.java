package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ReapeatedAndMissing {

    public ArrayList<Integer> repeatedNumber(final List<Integer> Arr) {
        int N = Arr.size();
        int originalSum = N * (N+1) / 2;
        int currentSum = 0;
        int A = -1;
        int[] missing = new int[N+1];
        for(int val : Arr){
            missing[val]++;
            if(missing[val] >= 2){
                A = val;
                break;
            }
        }
        for(int val : Arr){
            currentSum += val;
        }
        int B = A + originalSum - currentSum;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A);
        ans.add(B);

        return ans;
    }

    public void repeatAndMissing(int[] nums){
        int N = nums.length;
        int xor = 0;

        for(int val : nums) xor = xor ^ val;
        for(int i = 1;i <= N;i++) xor = xor ^ i;

        int rsb = xor & -xor;
        int set1 = 0;
        int set2 = 0;
        for(int val : nums){
            if((rsb & val) == 0){
                set1 = set1 ^ val;
            }else{
                set2 = set2 ^ val;
            }
        }

        for(int i = 1;i <= N;i++){
            int val = i;
            if((rsb & val) == 0){
                set1 = set1 ^ val;
            }else{
                set2 = set2 ^ val;
            }
        }
        int repeating = 0;
        int missing = 0;
        for(int val : nums){
            if(val == set1){
                repeating = set1;
                missing = set2;
                break;
            }else if(val == set2){
                repeating = set2;
                missing = set1;
                break;
            }
        }

        System.out.println(repeating+" "+missing);
    }

    public static void main(String[] args) {
        ReapeatedAndMissing ram = new ReapeatedAndMissing();
        int[] nums = new int[]{4,2,3,4,5};
        ram.repeatAndMissing(nums);
    }
}
