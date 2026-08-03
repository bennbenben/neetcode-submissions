class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // nums = 1,2,1,0,4,2,6, k = 3
    System.out.printf("input nums=%s, k=%d%n", Arrays.toString(nums), k);
    
    List<Integer> maxWindows = new ArrayList<Integer>();
    
    int slowPointer=0, fastPointer=k-1;
    while (fastPointer < nums.length) {
      int maxWindowValue = Integer.MIN_VALUE;
      for (int i=slowPointer; i<=fastPointer; i++) {
        maxWindowValue = Math.max(maxWindowValue, nums[i]);
      }
      maxWindows.add(maxWindowValue);
      slowPointer+=1; fastPointer+=1;
    }
    
    System.out.printf("maxWindows=%s%n", Arrays.toString(maxWindows.toArray()));
    
    int[] maxWindowArray = new int[maxWindows.size()];
    for (int i=0; i<maxWindows.size(); i++) {
      maxWindowArray[i] = maxWindows.get(i);
    }
    
    return maxWindowArray;
  }
  
}
