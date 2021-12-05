package Arrays;

public class Kadane {
    /* Q1.) Find Maximum SubArray Sum among a given Array
        Brute Force -> O(N^2)
        Optimal ->
            maxEndHere -> 0
            maxSoFar -> MIN
            i = 0 -> N
                maxEndHere = maxEndHere + arr.get(i)
                if maxEndHere > maxSoFar -> maxSoFar = maxEndHere
                if maxEndHere < 0 -> maxEndHere = 0;
    */
    public int solve(int[] arr){
        int maxEndHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int start = 0;
        int end = -1;
        int _start = -1;

        for(int i = 0;i < arr.length;i++) {
            maxEndHere += arr[i];
            if (maxEndHere > maxSoFar) {
                start = _start;
                end = i;
                maxSoFar = maxEndHere;
            }
            if (maxEndHere < 0) {
                _start = i + 1;
                maxEndHere = 0;
            }
        }
        //if(maxEndHere < 0) return 0;
        System.out.println(start+" "+end);
        return maxSoFar;
    }
    public static void main(String[] args) {
        Kadane obj = new Kadane();
        int[] arr = new int[]{-5,-2,1,2,-3,-4,-1};
        System.out.println(obj.solve(arr));
    }
}
