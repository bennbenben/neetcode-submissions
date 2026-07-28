class Solution {
  public int trap(int[] height) {
    int heightLength = height.length; // 10
    int[] leftPeaks = new int[height.length];
    int[] rightPeaks = new int[height.length];
    
    for (int i=1; i<=heightLength-1;i++) { // iteration - index 9 needs to be included
      leftPeaks[i] = Math.max(leftPeaks[i-1], height[i-1]); // index 1
      rightPeaks[heightLength-1-i] = Math.max(rightPeaks[heightLength-i], height[heightLength-i]); // index 8
      
    }
    
    System.out.println("height=" + Arrays.toString(height));
    System.out.println("leftPeaks=" + Arrays.toString(leftPeaks));
    System.out.println("rightPeaks=" + Arrays.toString(rightPeaks));
    
    int shortestPeak, unitsOfWater = 0;
    for (int i=0; i<heightLength; i++) {
      shortestPeak = Math.min(leftPeaks[i], rightPeaks[i]);
      System.out.println("inside index=" + i + ", shortestPeak=" + shortestPeak + ", height=" + height[i]);
      if (shortestPeak > height[i]) {
        unitsOfWater += (shortestPeak - height[i]);
        System.out.println("unitsOfWater=" + unitsOfWater);
      }
    }
    
    return unitsOfWater;
  }
}
