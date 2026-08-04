class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0]-a[0]);
    for (int i=0; i<k; i++) {
      maxHeap.offer(new int[] {nums[i], i});
    }
    
//    int[] maxWindowArray = new int[nums.length-k+1]; // nums.length-k+1 will return the number of windows
    List<Integer> maxWindows = new ArrayList<Integer>();
    
    int slowPointer=0, fastPointer=k-1;
    while (fastPointer<nums.length) {
      
      // If index < slowPointer, entry is already out of the window
      while (maxHeap.peek()[1] < slowPointer) {
        maxHeap.poll();
      }
      maxWindows.add(maxHeap.peek()[0]);
      
      slowPointer +=1; fastPointer +=1;
      if (fastPointer < nums.length)
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
    }
    
    int[] maxWindowArray = new int[maxWindows.size()];
    for (int i=0; i<maxWindows.size(); i++) {
      maxWindowArray[i] = maxWindows.get(i);
    }
    
    return maxWindowArray;
  }
  
}
