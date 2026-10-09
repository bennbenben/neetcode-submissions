class Solution {
  public int longestConsecutive(int[] nums) {
    
    Set<Integer> numsSet = new HashSet<Integer>();
    for (int num : nums) {
      numsSet.add(num);
    }
    
    int ongoingStreak=0;
    for (int num : numsSet) {
      if (numsSet.contains(num-1)) {
        continue;
      }
      
      int currentStreak=1;
      int nextNum = num + 1;
      while (numsSet.contains(nextNum)) {
        currentStreak += 1;
        nextNum += 1;
      }
      ongoingStreak = Math.max(currentStreak, ongoingStreak);
    }
    return ongoingStreak;
    
  }
}
