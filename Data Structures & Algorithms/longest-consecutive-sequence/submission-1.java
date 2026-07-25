class Solution {
  public int longestConsecutive(int[] nums) {
    Set<Integer> numsSet = new HashSet<>();
    for (int num : nums) {
      numsSet.add(num);
    }

//    int[] numsArray = numsSet.stream().mapToInt(a -> a.intValue()).toArray();

    int longestConsecutiveCount = 0, thisConsecutiveCount = 0;

    for (int num : numsSet) {
      
      if (numsSet.contains(num-1)) { // slight optimization
        continue;
      }
      
      thisConsecutiveCount = 1;
    //   System.out.println("processing num=" + num + ". current count = " + thisConsecutiveCount);
      int nextNum = num + 1;
    //   System.out.println("nextNum=" + nextNum);
      
      while (numsSet.contains(nextNum)) {
        // System.out.println("Found the nextNum=" + nextNum);
        thisConsecutiveCount += 1;
        nextNum = nextNum + 1;
        // System.out.println("thisConsecutiveCount=" + thisConsecutiveCount + ". Finding the nextNum=" + nextNum);
        
      }
      
    //   System.out.println("Final thisConsecutiveCount=" + thisConsecutiveCount);

      if (longestConsecutiveCount < thisConsecutiveCount) {
        longestConsecutiveCount = thisConsecutiveCount;
        // System.out.println("longestConsecutiveCount streak is = " + longestConsecutiveCount);
      }

    }
    return longestConsecutiveCount;
  }
  
}
