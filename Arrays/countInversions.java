package Arrays;
import java.util.*;

public class countInversions {

    private int merge(int[] nums,int left,int mid,int right){
        int N = right - left + 1;
        int[] buffer = new int[N];
        int t = 0;
        int lp = left;
        int rp = mid + 1;
        int inversionCount = 0;

        while(lp <= mid && rp <= right){
            if(nums[lp] <= nums[rp]){
                buffer[t++] = nums[lp++];
            }else{
                buffer[t++] = nums[rp++];
                inversionCount += (mid - lp) + 1; /**This is the only addition in merge Sort code to calculate inversion count**/
            }
        }

        while(lp <= mid){
            buffer[t++] = nums[lp++];
        }
        while(rp <= right){
            buffer[t++] = nums[rp++];
        }

        for(int i = left;i <= right;i++){
            nums[i] = buffer[i - left];
        }

        return inversionCount;
    }
    //right is the lastIndex inclusive
    public int mergeSort(int[] nums,int left,int right){
        if(left >= right) return 0;

        int mid = left + (right - left)/2;
        int leftCount = mergeSort(nums,left,mid);
        int rightCount = mergeSort(nums,mid+1,right);
        int mergeCount = merge(nums,left,mid,right);

        return leftCount + rightCount +  mergeCount;
    }
    public static void main(String[] args) {
        countInversions countInvObj = new countInversions();
        int[] nums = new int[]{3,1,2};
        int N = nums.length;
        int ans = countInvObj.mergeSort(nums,0,N - 1);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}

/*
                        [1,2,3]
                         /   \
                       [1,3] [2]
                        /  \
                       [3]  [1]
*/
