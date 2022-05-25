package DynamicProgramming.LIS;

import java.util.Arrays;

/*
    Problem Statement- Given an integer array, return the length 
    of the longest strictly increasing subsequence.
*/
public class ParentProblem {
    
    //Time Complexity - O(n*n)
    //Space Complexity - O(n)
    static int LongestIncreasingSubsequenceBottomUp(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int lengthOfLongestSubsequence = Integer.MIN_VALUE;

        for(int i = 1;i < n;i++){
            int lengthTillCurrentPoint = 1;
            for(int k = 0;k < i;k++){
                if(arr[k] < arr[i]){
                    lengthTillCurrentPoint = Math.max(lengthTillCurrentPoint, 1 + dp[k]);
                }
            }
            dp[i] = lengthTillCurrentPoint;
            lengthOfLongestSubsequence = Math.max(dp[i],lengthOfLongestSubsequence);    
        }

        return lengthOfLongestSubsequence;
    }

    static int insertionIndex(int[] arr,int left,int right,int val){
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == val) return mid;
            else if(arr[mid] > val){ 
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    static int LongestIncreasingSubsequenceFaster(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int len = 1;

        for(int i = 1;i < n;i++){
            if(arr[i] > dp[len - 1]){
                dp[len++] = arr[i];
            }else{
                int index = insertionIndex(dp,0,len,arr[i]);
                dp[index] = arr[i];
            }
        }

        System.out.println(Arrays.toString(dp));

        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 10,9,2,5,3,7,101,18 };
        System.out.println(LongestIncreasingSubsequenceFaster(arr));
    }
}
