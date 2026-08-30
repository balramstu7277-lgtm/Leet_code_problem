class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int k = n/3;
        int count1 = 0 ;
        int count2 = 0;
        int num1 = 0;
        int num2 = 0;
        for(int i = 0 ; i < n ;i++){
            if(nums[i]== num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
            else if(count1 == 0){
                num1 = nums[i];
                count1++; 
            }
            else if(count2 == 0 ){
                num2 = nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int fre1 = 0 ;
        int fre2 = 0 ;
    
        for(int i =0 ; i < n ;i++){
            if(nums[i]== num1){
                fre1++;
            }
            else if(nums[i]==num2){
                fre2++;
            }

        }
        if(fre1 > k ){
            ans.add(num1);
                
            }
        if(fre2 > k){
            ans.add(num2);
        }
        
        return ans;
        
    }
}