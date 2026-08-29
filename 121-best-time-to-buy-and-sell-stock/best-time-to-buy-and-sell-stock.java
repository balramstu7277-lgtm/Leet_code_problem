class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length ; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                int profit = prices[i] - buy;
                maxprofit = Math.max(maxprofit, profit);
            }
        }
        if (maxprofit < 0)
            return 0;
        else
            return maxprofit;
    }
}