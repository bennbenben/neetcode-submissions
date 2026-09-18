class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length()!=t.length()) {
      return false;
    }
    int[] freqHashTable = new int[26];
    for (int i=0; i<s.length(); i++) {
      freqHashTable[s.charAt(i) - 'a'] += 1;
      freqHashTable[t.charAt(i) - 'a'] -= 1;
    }
    for (int i=0; i<freqHashTable.length; i++) {
      if (freqHashTable[i] != 0) {
        return false;
      }
    }
    return true;
  }

}
