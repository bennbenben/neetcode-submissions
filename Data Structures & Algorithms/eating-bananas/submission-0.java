class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int low = 1; int high = 0;
    for (int pile : piles) {
      high = Math.max(pile, high);
    }
    
    while (low < high) {
      int mid = low + (high - low) / 2;
      
      long totalTimePerPiles=0; int timePerPile=0;
      for (int pile: piles) {
        timePerPile = (int) Math.ceil(pile / (double) mid);
        totalTimePerPiles += timePerPile;
      }
      
      if (totalTimePerPiles > h) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    
    return low;
  }

}
