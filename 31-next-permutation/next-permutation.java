class Solution { 

    public void Swap(int[] arr, int i, int j) { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    } 
 
    public void nextPermutation(int[] nums) { 
        int i = nums.length - 2; 

        // If array has 0 or 1 element
        if(nums.length <= 1){ 
            return; 
        } 
 
        // Find the first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) { 
            i--; 
        } 

        if (i >= 0) { 
            int j = nums.length - 1; 

            // Find element greater than nums[i]
            while (nums[i] >= nums[j]) { 
                j--; 
            } 

            // Swap pivot and next greater element
            Swap(nums, i, j); 
        } 

        int j = nums.length - 1; 
 
        // Reverse the remaining elements
        while (i + 1 < j) { 
            Swap(nums, i + 1, j); 
            i++;  
            j--; 
        } 
    } 
}