class Solution {
    public void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int i = 0;
        int mid = 0;
        int j = nums.length - 1;
        while (mid <= j) {
            if (nums[mid] == 0) {
                Swap(nums, i, mid);
                i++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                Swap(nums, mid, j);
                j--;
            }

        }

    }
}