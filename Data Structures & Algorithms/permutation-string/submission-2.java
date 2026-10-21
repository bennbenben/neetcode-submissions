class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    
    char[] s1CharArray = s1.toCharArray();
    char[] s2CharArray = s2.toCharArray();
    
    Map<Character, Integer> s1FreqMap = new HashMap<Character, Integer>();
    for (int i=0; i<s1.length(); i++) {
      s1FreqMap.put(s1CharArray[i], s1FreqMap.getOrDefault(s1CharArray[i], 0)+1);
    }
    
    int slowPointer=0, fastPointer=s1.length()-1;
    Map<Character, Integer> s2SubFreqMap = new HashMap<Character, Integer>();
    for (int i=0; i<=fastPointer; i++) {
      s2SubFreqMap.put(s2CharArray[i], s2SubFreqMap.getOrDefault(s2CharArray[i], 0)+1);
    }
    
    while (fastPointer < s2.length()) {
      if (s1FreqMap.equals(s2SubFreqMap)) {
        return true;
      } else {
        int slowPointerValue = s2SubFreqMap.get(s2CharArray[slowPointer])-1;
        if (slowPointerValue == 0) {
          s2SubFreqMap.remove(s2CharArray[slowPointer]);
        } else {
          s2SubFreqMap.put(s2CharArray[slowPointer], slowPointerValue);
        }
        slowPointer += 1; 
        
        fastPointer += 1;
        if (fastPointer == s2.length()) {
          return false;
        } 
        int fastPointerValue = s2SubFreqMap.getOrDefault(s2CharArray[fastPointer], 0)+1;
        s2SubFreqMap.put(s2CharArray[fastPointer],fastPointerValue);
      }
    }
    return false;
  }
}
