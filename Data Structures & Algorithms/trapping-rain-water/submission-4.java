class Solution {
  public int trap(int[] height) {
    int[] leftArray = new int[height.length];
    int[] rightArray = new int[height.length];
    
    leftArray[0] = height[0];
    rightArray[height.length-1] = height[height.length-1];
    
    for (int i=1; i<=height.length-1; i++) {
      if (height[i] > leftArray[i-1]) {
        leftArray[i] = height[i];
      } else {
        leftArray[i] = leftArray[i-1];
      }
    }
    
    for (int i=height.length-2; i>=0; i--) {
      if (height[i] > rightArray[i+1]) {
        rightArray[i] = height[i];
      } else {
        rightArray[i] = rightArray[i+1];
      }
    }
    
    int trappedWater = 0;
    for (int i=0; i<=height.length-1; i++) {
      trappedWater += Math.min(leftArray[i], rightArray[i]) - height[i];
    }
    
    return trappedWater;
  }
}
