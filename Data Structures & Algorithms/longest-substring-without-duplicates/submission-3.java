class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0; 
    }
    
    int slowPointer=0, fastPointer = slowPointer+1;
    int maxStreak=1;
    
    char[] inputSubstring = s.toCharArray();
    Set<Character> streakContainer = new HashSet<Character>();
    streakContainer.add(inputSubstring[slowPointer]);
    
    while (fastPointer < s.length()) {
      while (streakContainer.contains(inputSubstring[fastPointer])) {
        streakContainer.remove(inputSubstring[slowPointer]);
        slowPointer+=1;
      } 
      
      streakContainer.add(inputSubstring[fastPointer]);
      maxStreak = Math.max(maxStreak, streakContainer.size());
      fastPointer += 1;
    }
    
    return maxStreak;
  }
}
