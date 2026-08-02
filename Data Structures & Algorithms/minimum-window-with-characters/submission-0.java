class Solution {
  public String minWindow(String s, String t) {
    // edge case
    if (t.length()>s.length())
      return "";
    
    // s=OUZODYXAZV, t=XYZ
    System.out.printf("Input string s=%s, string t=%s%n", s, t);
    Map<Character,Integer> tFreqMap = new HashMap<Character,Integer>();
    Map<Character,Integer> sFreqMap = new HashMap<Character,Integer>();
    for (int i=0; i<t.length(); i++) {
      tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0)+1);
      sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0)+1);
    }
    System.out.printf("tFreqMap=%s%n", tFreqMap.toString());
    System.out.printf("sFreqMap=%s%n", sFreqMap.toString());
    
    int slowPointer=0, fastPointer=t.length()-1;
    int minSlowPointer=0, minFastPointer=Integer.MAX_VALUE;
    int lengthOfMinSubString = Integer.MAX_VALUE;
    
    while (slowPointer < s.length()) {
      System.out.printf("slowPointer=%d, fastPointer=%d%n", slowPointer, fastPointer);
      
      // introduce checking condition on the frequency maps
      while (this.frequencyMapEqualsOrMore(sFreqMap, tFreqMap)) {
        System.out.printf("sFreqMap=%s equals tFreqMap=%s%n", sFreqMap.toString(), tFreqMap.toString());
        
        int lengthOfThisSubString = fastPointer - slowPointer + 1;
        if (lengthOfThisSubString < lengthOfMinSubString) {
          minSlowPointer = slowPointer; minFastPointer = fastPointer; 
          lengthOfMinSubString = lengthOfThisSubString;
        }
        
        // start shrinking the minimum window. increment slowPointer and update sFreqMap
        Character slowPointerValue = s.charAt(slowPointer);
        int newSlowPointerValueFreq = sFreqMap.get(slowPointerValue)-1;
        if (newSlowPointerValueFreq == 0) {
          sFreqMap.remove(slowPointerValue);
        } else {
          sFreqMap.put(slowPointerValue, newSlowPointerValueFreq);
        }
        slowPointer += 1;
      }
      System.out.printf("sFreqMap=%s NOT equals tFreqMap=%s%n", sFreqMap.toString(), tFreqMap.toString());
      
      // increment the fastPointer and update sFreqMap
      fastPointer +=1;
      if (fastPointer < s.length()) {
        sFreqMap.put(s.charAt(fastPointer), sFreqMap.getOrDefault(s.charAt(fastPointer),0)+1);
      } else {
        break;
      }
    }
    
    System.out.printf("Identifed minSlowPointer=%d, minFastPointer=%d%n%n", minSlowPointer, minFastPointer);
    
    if (lengthOfMinSubString == Integer.MAX_VALUE) {
      return "";
    } else {
      StringBuilder sb = new StringBuilder();
      while (minSlowPointer <= minFastPointer) {
        sb.append(s.charAt(minSlowPointer));
        minSlowPointer++;
      }
      System.out.println("sb.toString()=" + sb.toString());
      return sb.toString();
    }
  }
  
  private boolean frequencyMapEqualsOrMore(Map<Character,Integer> sFreqMap, Map<Character,Integer> tFreqMap) {
    for (Map.Entry<Character,Integer>entry:tFreqMap.entrySet()) {
      Character tMapKey = entry.getKey();
      if (!sFreqMap.containsKey(tMapKey)) {
        return false;
      }
      Integer tMapValue = entry.getValue();
      Integer sMapValue = sFreqMap.get(tMapKey);
      if (sMapValue < tMapValue) {
        return false;
      }
    }
    return true;
  }
}
