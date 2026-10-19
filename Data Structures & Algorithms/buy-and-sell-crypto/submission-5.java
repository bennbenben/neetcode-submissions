class Solution {
  public int maxProfit(int[] prices) {
    int[] buyArray = new int[prices.length], sellArray = new int[prices.length];
    buyArray[0] = prices[0]; 
    sellArray[prices.length-1] = prices[prices.length-1];
    
    for (int i=1; i<prices.length;i++) {
      int lowestBuy = Math.min(buyArray[i-1], prices[i]);
      buyArray[i] = lowestBuy;
    }
    
    for (int i=prices.length-2; i>=0; i--) {
      int highestSell = Math.max(sellArray[i+1], prices[i]);
      sellArray[i] = highestSell;
    }
    
    int maxProfit = 0, profit = 0;
    for (int i=0; i<prices.length; i++) {
      profit = sellArray[i] - buyArray[i];
      maxProfit = Math.max(maxProfit, profit);
    }
    
    return maxProfit;
  }
}
