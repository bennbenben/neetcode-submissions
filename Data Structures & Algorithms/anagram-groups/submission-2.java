class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedStr = String.valueOf(charArray);
      
      if (anagramMap.containsKey(sortedStr)) {
        anagramMap.get(sortedStr).add(str);
      } else {
        anagramMap.put(sortedStr, new ArrayList<String>());
        anagramMap.get(sortedStr).add(str);
      }
    }
    
    List<List<String>> groupAnagram = new ArrayList<List<String>>();
    groupAnagram.addAll(anagramMap.values());
    return groupAnagram;
  }

}
