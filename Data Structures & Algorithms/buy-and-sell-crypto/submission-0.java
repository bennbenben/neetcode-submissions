class Solution {
  public int maxProfit(int[] prices) {
    
    int[] buyArray = new int[prices.length];
    int[] sellArray = new int[prices.length];
    
    buyArray[0] = prices[0];
    for (int i=1; i<prices.length;i++) {
      buyArray[i] = Math.min(buyArray[i-1], prices[i]);
    }
    
    System.out.printf("buyArray=%s%n", Arrays.toString(buyArray));
    
    sellArray[prices.length-1] = prices[prices.length-1];
    for (int i=prices.length-1-1; i>-1; i--) {
      sellArray[i] = Math.max(sellArray[i+1], prices[i]);
    }
    
    System.out.printf("sellArray=%s%n", Arrays.toString(sellArray));
    
    int maxProfit=0;
    for (int i=0; i<prices.length; i++) {
      maxProfit = Math.max(maxProfit, sellArray[i] - buyArray[i]);
    }
    
    System.out.printf("maxProfit=%s%n", maxProfit);
    
    return maxProfit;
    
  }

}
