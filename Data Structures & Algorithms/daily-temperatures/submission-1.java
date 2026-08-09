class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    
    LinkedList<Integer> currentHighestTempIndexes = new LinkedList<Integer>();
    int[] resultsArray = new int[temperatures.length];
    
    for (int i=temperatures.length-1; i>=0; i--) {
      // System.out.printf("Evaluating current index i=%d (temperatures[i]=%d)%n",i, temperatures[i]);
      // System.out.printf("Stack before: %s%n", currentHighestTempIndexes);
      
      if (currentHighestTempIndexes.isEmpty()) {
        currentHighestTempIndexes.offerFirst(i);
      
      } else {
        // System.out.printf("Evaluating temperatures[i]>=temperatures[currentHighestTempIndexes.peekFirst()]");
        while (!currentHighestTempIndexes.isEmpty() && temperatures[i] >= temperatures[currentHighestTempIndexes.peekFirst()]) {
          currentHighestTempIndexes.pollFirst();
        }
        
        if (!currentHighestTempIndexes.isEmpty()) {
          resultsArray[i] = currentHighestTempIndexes.peekFirst()-i;
        }
        
        currentHighestTempIndexes.offerFirst(i);
        
      }
    }
    
    // System.out.printf("resultsArray=%s%n", Arrays.toString(resultsArray));
    return resultsArray;
  }
}
