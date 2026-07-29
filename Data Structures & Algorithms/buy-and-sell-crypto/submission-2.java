class Solution {
  public int maxProfit(int[] prices) {
    int slowPointer=0, fastPointer=1;
    int maxProfit=0, currentProfit=0;
    
    while (fastPointer < prices.length) {
      // System.out.printf("Current iteration slowPointer=%d, fastPointer=%d%n", slowPointer, fastPointer);
      // System.out.printf("slowPointerValue=%d, fastPointerValue=%d%n", prices[slowPointer], prices[fastPointer]);
      
      currentProfit = prices[fastPointer] - prices[slowPointer];
      // System.out.printf("currentProfit=%d%n", currentProfit);
      
      maxProfit = Math.max(maxProfit, currentProfit);
      // System.out.printf("maxProfit=%d%n", maxProfit);
      
      if (prices[fastPointer] < prices[slowPointer]) {
        slowPointer = fastPointer;
        fastPointer = slowPointer+1;
        // System.out.printf("fastPointer is < slowPointer. Updating slowPointer=%d, fastPointer=%d%n", slowPointer, fastPointer);
      } else {
        fastPointer += 1;
        // System.out.printf("fastPointer is >= slowPointer. Updating fastPointer=%d%n", fastPointer);
      }
      
    }
    
    return maxProfit;
  }

}
