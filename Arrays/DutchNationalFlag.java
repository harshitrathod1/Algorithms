package Arrays;

public class DutchNationalFlag {

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void dnfSort(int[] nums) {
        int N = nums.length;
        int low = 0;
        int mid = 0;
        int high = N - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums,mid,low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums,mid,high);
                high--;
            }
        }

        for (int val : nums) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
        DutchNationalFlag dnf = new DutchNationalFlag();
        int[] nums = new int[]{0,0,2,2,1,1,0,2,1,2,0,0,1};
        dnf.dnfSort(nums);
    }
}
