class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> anagramGroup = new HashMap<String, List<String>>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);

      List<String> existingValues = anagramGroup.get(key);
      if (existingValues == null) {
        existingValues = new ArrayList<String>();
        anagramGroup.put(key, existingValues);
      }

      existingValues.add(str);
    }

    return new ArrayList<List<String>>(anagramGroup.values());

  }
}
