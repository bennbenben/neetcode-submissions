class Solution {
  public int maxProfit(int[] prices) {
    int slowPointer=0, fastPointer=slowPointer+1;
    int maxProfit=0, profit=0;
    
    while (fastPointer<prices.length) {
      profit = prices[fastPointer] - prices[slowPointer];
      maxProfit = Math.max(maxProfit, profit);
      if (prices[fastPointer] < prices[slowPointer]) {
        slowPointer = fastPointer;
        fastPointer += 1;
      } else {
        fastPointer += 1;
      }
    }
    return maxProfit;
  }

}
