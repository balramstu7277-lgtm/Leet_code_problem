class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i =0 ;
        int j = 1;
        while(j != nums.length){
             if(nums[i] != nums[j]) {
                i++;
                count++;
                nums[i] = nums[j];
                j++;

            }
            else{
                j++;
            }
        }
        
        return count;
    }
}