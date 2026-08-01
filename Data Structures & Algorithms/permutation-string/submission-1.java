class Solution {
  public boolean checkInclusion(String s1, String s2) {
    
    if (s1.length() > s2.length()) {
      return false;
    }

    char[] s1CharArray = s1.toCharArray();
    Map<Character, Integer> s1FrequencyMap = new HashMap<>();
    
    for (char s1Char:s1CharArray) {
      int s1CharFreq = s1FrequencyMap.getOrDefault(s1Char, 0)+1;
      s1FrequencyMap.put(s1Char, s1CharFreq);
    }
    System.out.printf("s1FrequencyMap=%s%n", s1FrequencyMap.toString());
    
    int leftPointer=0, rightPointer = s1.length()-1;
    char[] s2SubCharArray = s2.substring(leftPointer, s1.length()).toCharArray();
    Map<Character, Integer> s2SubCharArrayFrequencyMap = new HashMap<Character, Integer>();
    
    for (char s2SubChar:s2SubCharArray) {
      int s2SubCharFreq = s2SubCharArrayFrequencyMap.getOrDefault(s2SubChar, 0)+1;
      s2SubCharArrayFrequencyMap.put(s2SubChar, s2SubCharFreq);
    }
    System.out.printf("s2SubCharArrayFrequencyMap=%s%n", s2SubCharArrayFrequencyMap.toString());
    char[] s2CharArray = s2.toCharArray();
    
    while (rightPointer < s2.length()) {
      System.out.printf("leftPointer=%d, rightPointer=%d %n", leftPointer, rightPointer);
      System.out.printf("s2SubCharArrayFrequencyMap=%s%n", s2SubCharArrayFrequencyMap.toString());
      
      if (s1FrequencyMap.equals(s2SubCharArrayFrequencyMap)) {
        return true;
      
      } else {
        
        // decrement frequency (key=leftPointer from s2CharArray) from s2SubCharArrayFrequencyMap
        // increment leftPointer += 1
        char leftPointerValue = s2CharArray[leftPointer];
        int newLeftPointerValueFreq = s2SubCharArrayFrequencyMap.get(leftPointerValue) - 1;
        System.out.printf("within s2SubCharArrayFrequencyMap, update key=%s, value=%d%n", leftPointerValue, newLeftPointerValueFreq);
        if (newLeftPointerValueFreq == 0) {
          s2SubCharArrayFrequencyMap.remove(leftPointerValue);
        } else {
          s2SubCharArrayFrequencyMap.put(leftPointerValue, newLeftPointerValueFreq);
        }
        leftPointer +=1; 
        
        // increment rightPointer += 1
        // increment frequency (key=newly added rightPointer value) from s2SubCharArrayFrequencyMap 
        rightPointer +=1;
        if (rightPointer == s2.length()) {
          break;
        }
        char rightPointerValue = s2CharArray[rightPointer];
        int rightPointerValueFreq = s2SubCharArrayFrequencyMap.getOrDefault(rightPointerValue, 0)+1;
        s2SubCharArrayFrequencyMap.put(rightPointerValue, rightPointerValueFreq);
        System.out.printf("rightPointer=%d. within s2SubCharArrayFrequencyMap, update key=%s, value=%d %n", rightPointer, rightPointerValue, rightPointerValueFreq);
      }
    }
    
    return false;
  }
}
