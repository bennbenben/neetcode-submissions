class Solution {
  public int lengthOfLongestSubstring(String s) {
    char[] sArray = s.toCharArray();
    int slowPointer=0, fastPointer=0;
    Set<Character> sSet = new HashSet<Character>();
    int streak=0;
    
    while (fastPointer < sArray.length) {
      if (!sSet.contains(sArray[fastPointer])) {
        sSet.add(sArray[fastPointer]);
        streak = Math.max(streak, sSet.size());
        fastPointer += 1;
      } else {
        sSet.remove(sArray[slowPointer]);
        slowPointer += 1;
      }
    }
    
    return streak;
  }
}
