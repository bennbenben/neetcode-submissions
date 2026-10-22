class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<Integer> windowDeque = new LinkedList<Integer>();
    int slowPointer=0, fastPointer=0;
    List<Integer> maxWindowValuesList = new ArrayList<Integer>();
    
    while (fastPointer<nums.length) {
      while (windowDeque.size()>0 && slowPointer > windowDeque.peekFirst()) {
        windowDeque.pollFirst();
      }
      
      while (windowDeque.size()>0 && nums[fastPointer]>nums[windowDeque.peekLast()]) {
        windowDeque.pollLast();
      }
      
      windowDeque.offer(fastPointer);
      int windowLength = fastPointer - slowPointer + 1;
      if (windowLength < k) {
        fastPointer += 1;
      } else {
        maxWindowValuesList.add(nums[windowDeque.peekFirst()]);
        slowPointer += 1; fastPointer += 1;
      }
    }
    
    int[] maxWindowValuesArray = new int[maxWindowValuesList.size()];
    for (int i=0; i<maxWindowValuesList.size(); i++) {
      maxWindowValuesArray[i]=maxWindowValuesList.get(i);
    }
    return maxWindowValuesArray;
  }
}
