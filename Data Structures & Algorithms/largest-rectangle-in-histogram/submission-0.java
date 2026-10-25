class Solution {
  public int largestRectangleArea(int[] heights) {
    LinkedList<int[]> heightsStack = new LinkedList<int[]>();
    int maxArea = 0;
    
    for (int i=0; i<heights.length; i++) {
//      System.out.printf("current index i=%d%n", i);
      int prevHeightIndex = i;
      while (!heightsStack.isEmpty() && heights[i] < heightsStack.peekFirst()[0]) {
//        System.out.printf("Existing stack=%s, comparing against incoming value=%s%n", Arrays.deepToString(heightsStack.toArray()), heights[i]);
        int[] prevHeight = heightsStack.pollFirst();
        maxArea = Math.max(maxArea, prevHeight[0] * (i-prevHeight[1]));
        prevHeightIndex = prevHeight[1];
      }
      heightsStack.offerFirst(new int[] {heights[i], prevHeightIndex});
    }
//    System.out.printf("Existing stack=%s%n", Arrays.deepToString(stack.toArray()));
    
    // leftover items in the stack means there was never a shorter wall on the right
    while (!heightsStack.isEmpty()) {
      int[] prevHeight = heightsStack.pollFirst();
      maxArea = Math.max(maxArea, prevHeight[0] * (heights.length-prevHeight[1]));
    }
    
    return maxArea;
  }
}
