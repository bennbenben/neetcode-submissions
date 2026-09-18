class Solution {
    public boolean isAnagram(String s, String t) {
            if (s.length()!=t.length()) {
      return false;
    }
      Map<Character, Integer> sFreqMap = new HashMap<Character, Integer>();
      Map<Character, Integer> tFreqMap = new HashMap<Character, Integer>();
    
      for (int i=0; i<s.length(); i++) {
        sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0) + 1);
      }
    
      return sFreqMap.equals(tFreqMap);
    }
}
