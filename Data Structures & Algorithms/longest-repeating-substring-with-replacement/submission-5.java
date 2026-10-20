class Solution {
  public int characterReplacement(String s, int k) {
    int slowPointer=0, fastPointer=0;
    Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
    
    int maxLength=0, currentLength=fastPointer-slowPointer+1;
    int highestFreq=0;
    
    while (fastPointer < s.length()) {
      freqMap.put(s.charAt(fastPointer), freqMap.getOrDefault(s.charAt(fastPointer), 0)+1);
      currentLength = fastPointer - slowPointer + 1;
      
      highestFreq = Math.max(highestFreq, freqMap.get(s.charAt(fastPointer)));
      
      // to check if the existing window is valid
      while (!(currentLength - highestFreq <= k)) {
        int slowPointerFreq = freqMap.get(s.charAt(slowPointer));
        slowPointerFreq -= 1;

        if (slowPointerFreq == 0) {
          freqMap.remove(s.charAt(slowPointer));
        } else {
          freqMap.put(s.charAt(slowPointer), slowPointerFreq);
        }
        
        slowPointer += 1;
        currentLength = fastPointer - slowPointer + 1;
      }
      
      maxLength = Math.max(maxLength, currentLength);
      fastPointer += 1;
    }
    
    return maxLength;
  }
}
