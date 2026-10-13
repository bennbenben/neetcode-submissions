class Solution {
  public int trap(int[] height) {
    int left=0, right=height.length-1;
    int leftMax=0, rightMax=0;
    int trappedWater=0;
    
    while (left < right) {
      if (height[left] <= height[right]) {
        leftMax = Math.max(leftMax, height[left]);
        trappedWater += leftMax - height[left];
        left += 1;
      } else {
        rightMax = Math.max(rightMax, height[right]);
        trappedWater += rightMax - height[right];
        right -= 1;
      }
    }
    
    return trappedWater;
  }

}
