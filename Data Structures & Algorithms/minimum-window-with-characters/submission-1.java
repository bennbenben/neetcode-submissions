class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> tFreqMap = new HashMap<Character, Integer>();
    for (int i=0; i<t.length(); i++) {
      tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0)+1);
    }
    
    Map<Character, Integer> sFreqMap = new HashMap<Character, Integer>();
    int slowPointer=0, fastPointer=0;
    int minWindowLength=Integer.MAX_VALUE, minStart=0, minEnd=0;
    while (fastPointer < s.length()) {
      int fastPointerValue = sFreqMap.getOrDefault(s.charAt(fastPointer), 0)+1;
      sFreqMap.put(s.charAt(fastPointer), fastPointerValue);
      
      // valid or not - if valid, shrink slowpointer. if not valid, add fastpointer
      while (this.freqMapEqualsOrMore(sFreqMap, tFreqMap)) {
        int windowLength = fastPointer - slowPointer +1;
        if (windowLength < minWindowLength) {
          minStart = slowPointer; minEnd = fastPointer;
          minWindowLength = windowLength;
        }
        
        int slowPointerValue = sFreqMap.get(s.charAt(slowPointer))-1;
        if (slowPointerValue == 0) {
          sFreqMap.remove(s.charAt(slowPointer));
        } else {
          sFreqMap.put(s.charAt(slowPointer), slowPointerValue);
        }
        slowPointer+=1;
      }

      fastPointer += 1;
    }
    
    if (minWindowLength==Integer.MAX_VALUE) {
      return "";
    } else {
      return s.substring(minStart, minEnd+1);
    }
  }
  
  public boolean freqMapEqualsOrMore(Map<Character, Integer> sFreqMap, Map<Character, Integer> tFreqMap) {
    for (Map.Entry<Character, Integer> entry : tFreqMap.entrySet()) {
      if (!sFreqMap.containsKey(entry.getKey())) {
        return false;
      }
      int sFreq = sFreqMap.get(entry.getKey());
      int tFreq = entry.getValue();
      if (sFreq < tFreq) {
        return false;
      }
    }
    return true;
  }
}
