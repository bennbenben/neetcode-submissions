class Solution {
  public int maxArea(int[] heights) {
    
    int left = 0, right = heights.length-1;
    int maxArea=0;
    
    while (left < right) {
      int currentArea = (right - left) * Math.min(heights[left], heights[right]);
      maxArea = Math.max(maxArea, currentArea);
      
      if (heights[left] <= heights[right]) {
        left += 1;
      } else if (heights[left] > heights[right]) {
        right -= 1;
      } 
    }
    
    return maxArea;
  }
}
