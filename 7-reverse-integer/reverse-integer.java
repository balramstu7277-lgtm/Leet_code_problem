class Solution {
    public int reverse(int x) {
        long reverse = 0;
        int sign = (x<0)?-1:1;
        if(x < 0){
            x = -x;
        }
        while(x>0){
           long digit = x %10 ;
           reverse = reverse * 10 + digit;
           if( reverse > Integer.MAX_VALUE){
            return 0;
           }
           x = x/10;
        }
    
        return (int)reverse * sign;
        
    }
}