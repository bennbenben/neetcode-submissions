class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<Integer> windowDeque = new LinkedList<Integer>();
    
    List<Integer> maxWindows = new ArrayList<Integer>();
    int slowPointer=0, fastPointer=0;
    
    while (fastPointer<nums.length) {
      while ((windowDeque.size()>0) && (windowDeque.peekFirst() < slowPointer)) {
        windowDeque.pollFirst();
      }
      
      while ((windowDeque.size()>0) && (nums[fastPointer] > nums[windowDeque.peekLast()])) {
        windowDeque.pollLast();
      }
      
      windowDeque.addLast(fastPointer);
      
      if (fastPointer >= k-1) {
        maxWindows.add(nums[windowDeque.peekFirst()]);
      }
      
      int existingWindowSize = fastPointer - slowPointer + 1;
      if (existingWindowSize < k) {
        fastPointer +=1;
      } else { 
        slowPointer +=1;
        fastPointer +=1;
      }
    }
    
    int[] maxWindowArray = new int[maxWindows.size()];
    for (int i=0; i<maxWindows.size(); i++) {
      maxWindowArray[i]=maxWindows.get(i);
    }
    return maxWindowArray;
  }
}
