class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    
    char[] s1CharArray = s1.toCharArray();
    char[] s2CharArray = s2.toCharArray();
    
    int[] s1FreqHashTable = new int[26];
    for (int i=0; i<s1.length(); i++) {
      s1FreqHashTable[s1CharArray[i] - 'a']+=1;
    }
    
    int slowPointer=0, fastPointer=s1.length()-1;
    int[] s2SubFreqHashTable = new int[26];
    for (int i=0; i<=fastPointer; i++) {
      s2SubFreqHashTable[s2CharArray[i]-'a']+=1;
    }
    
    while (fastPointer < s2.length()) {
      if (Arrays.equals(s1FreqHashTable, s2SubFreqHashTable)) {
        return true;
      } else {
        s2SubFreqHashTable[s2CharArray[slowPointer]-'a']-=1;
        slowPointer += 1; 
        
        fastPointer += 1;
        if (fastPointer == s2.length()) {
          return false;
        } 
        s2SubFreqHashTable[s2CharArray[fastPointer]-'a']+=1;
      }
    }
    return false;
  }
}
