class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<Integer> window = new LinkedList<Integer>();
    int slowPointer=0, fastPointer=0;
    
    List<Integer> maxWindowValuesList = new ArrayList<Integer>();
    
    while (fastPointer < nums.length) {
      
      while ((window.size()>0) && (window.peek() < slowPointer)) {
        window.pollFirst();
      }
      
      while ((window.size()>0) && (nums[fastPointer] > nums[window.peekLast()])) {
        window.pollLast();
      }
      
      window.offer(fastPointer);
      
      if (fastPointer - slowPointer + 1 < k) {
        fastPointer += 1;  
      } else {
        maxWindowValuesList.add(nums[window.peekFirst()]);
        fastPointer +=1; slowPointer += 1;
      }
    }
    
    int[] maxWindowValuesArray = new int[maxWindowValuesList.size()];
    for (int i=0; i<maxWindowValuesList.size(); i++) {
      maxWindowValuesArray[i] = maxWindowValuesList.get(i);
    }
    return maxWindowValuesArray;
  }


}
