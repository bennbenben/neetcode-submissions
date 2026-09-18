class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> numsSet = new HashSet<Integer>();
    for (int num:nums) {
      numsSet.add(num);
    }
    
    int maxConsecutiveCount=0;
    
    for (int num:numsSet) {
      if (numsSet.contains(num-1)) {
        continue;
      }
//      System.out.printf("num=%d\n",num);
      int nextNum = num+1;
      int consecutiveCount=1;
      
      while (numsSet.contains(nextNum)) {
        consecutiveCount += 1;
        nextNum += 1;
      }
      
      maxConsecutiveCount = Math.max(maxConsecutiveCount, consecutiveCount);
//      System.out.printf("maxConsecutiveCount=%d\n",maxConsecutiveCount);
    }
    return maxConsecutiveCount;
  }

}
