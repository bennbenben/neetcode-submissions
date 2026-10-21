class Solution {
    public String minWindow(String s, String t) {
    int tValidChars=0;
    int[] tFreqHashTable = new int[128];
    for (int i=0; i<t.length(); i++) {
      char c = t.charAt(i);
      if (tFreqHashTable[c] == 0) {
        tValidChars += 1;
      }
      tFreqHashTable[c] += 1;
    }
    
    int[] sFreqHashTable = new int[128];
    int sValidChars=0;
    
    int slowPointer=0, fastPointer=0;
    int minWindowLength=Integer.MAX_VALUE, minStart=0, minEnd=0;
    while (fastPointer < s.length()) {
      int fastPointerChar = s.charAt(fastPointer);
      sFreqHashTable[fastPointerChar]+=1;
      
      if (tFreqHashTable[fastPointerChar] > 0 && 
          tFreqHashTable[fastPointerChar] == sFreqHashTable[fastPointerChar]) {
        sValidChars+=1;
      }
      
      // valid or not - if valid, shrink slowpointer. if not valid, add fastpointer
      while (tValidChars==sValidChars) {
        int windowLength = fastPointer - slowPointer +1;
        if (windowLength < minWindowLength) {
          minStart = slowPointer; minEnd = fastPointer;
          minWindowLength = windowLength;
        }
        
        char slowPointerChar = s.charAt(slowPointer);
        sFreqHashTable[slowPointerChar] -= 1;
        if (tFreqHashTable[slowPointerChar] > 0 &&
            tFreqHashTable[slowPointerChar] > sFreqHashTable[slowPointerChar]) {
          sValidChars-=1;
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
}
