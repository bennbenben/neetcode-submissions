class Solution {
      public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> anagramGroup = new HashMap<String, List<String>>();

    for (String str : strs) {
      int[] alphabetsFrequency = new int[26];
      char[] chars = str.toCharArray();

      for (char c : chars) {
        int alphabet = c - 'a';
        System.out.println("alphabet is:" +  alphabet);
        alphabetsFrequency[alphabet] += 1;
      }

      String key = Arrays.toString(alphabetsFrequency);
      List<String> existingValue = anagramGroup.get(key);
      if (existingValue == null) {
        existingValue = new ArrayList<String>();
        anagramGroup.put(key, existingValue);
      }
      existingValue.add(str);

    }
    
    return new ArrayList<List<String>>(anagramGroup.values());
  }

}
