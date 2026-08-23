class Solution {
    public void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        if(nums.length <=1){
            return;
        }

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            Swap(nums, i, j);
        }
        int j = nums.length - 1;

        while (i + 1 < j) {
            Swap(nums, i + 1, j);
            i++;
            j--;
        }
    }
}