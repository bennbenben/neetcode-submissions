class Solution {
  public int trap(int[] height) {
    int left=0, right = height.length-1;
    int maxLeft=0, maxRight=0;
    int trappedWater = 0;
    
    while (left<right) {
      System.out.println("left index=" + left + ", left height=" + height[left] + ". right index=" + right + ", right height=" + height[right]);      
      System.out.println("maxLeft=" + maxLeft + ", maxRight=" + maxRight);      
      System.out.println("trappedWater=" + trappedWater);      
      
      maxLeft = Math.max(maxLeft, height[left]);
      if (maxLeft > height[left]) {
        System.out.println("maxLeft updated to " + maxLeft + ". Adding " + (maxLeft-height[left]) + " units of water");
        trappedWater = trappedWater + (maxLeft - height[left]);
        System.err.println("trappedWater=" + trappedWater);
      }
      
      
      maxRight = Math.max(maxRight, height[right]);
      if (maxRight > height[right]) {
        System.out.println("maxRight updated to " + maxRight + ". Adding " + (maxRight-height[right]) + " units of water");
        trappedWater = trappedWater + (maxRight - height[right]);
        System.err.println("trappedWater=" + trappedWater);
      }
      
      if (height[left] <= height[right]) {
        left += 1;
      } else if (height[left] > height[right]) {
        right -= 1;
      }
    }
    
    return trappedWater;
  }
}
