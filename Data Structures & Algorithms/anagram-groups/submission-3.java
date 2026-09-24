class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    for (String str : strs) {
      int[] alphabetsFrequency = new int[26];
      char[] chars = str.toCharArray();
      
      for (char c : chars) {
        int alphabet = c - 'a';
        alphabetsFrequency[alphabet] += 1;
      }
      
      String key = Arrays.toString(alphabetsFrequency);
      if (anagramMap.containsKey(key)) {
        anagramMap.get(key).add(str);
      } else {
        anagramMap.put(key, new ArrayList<String>());
        anagramMap.get(key).add(str);
      }
    }
    
    List<List<String>> groupAnagram = new ArrayList<List<String>>();
    groupAnagram.addAll(anagramMap.values());
    return groupAnagram;
  }

}
