class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0]-a[0]);
    int slowPointer=0, fastPointer=0;
    List<Integer> maxWindowValueList = new ArrayList<Integer>();
    
    while (fastPointer < nums.length) {
      
      while (maxHeap.size() > 0 && maxHeap.peek()[1] < slowPointer) {
        maxHeap.poll();
      }
      
      if (fastPointer - slowPointer + 1 < k) {
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
        fastPointer+=1;
      } else {
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
        maxWindowValueList.add(maxHeap.peek()[0]);
        fastPointer+=1; slowPointer+=1;
      }
    }
    
    int[] maxWindowValueArray = new int[maxWindowValueList.size()];
    for (int i=0; i<maxWindowValueList.size(); i++) {
      maxWindowValueArray[i] = maxWindowValueList.get(i);
    }
    return maxWindowValueArray;
  }
}
