class Solution {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str.length())
        .append('#')
        .append(str);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> decodedString = new ArrayList<String>();
    int i=0;
    while (i<str.length()) {
      int hashIndex = str.indexOf('#', i);
      int wordLength = Integer.valueOf(str.substring(i, hashIndex));
      String word = str.substring(hashIndex+1, hashIndex+1+wordLength);
      decodedString.add(word);
      i = hashIndex+1+wordLength;
    }
    return decodedString;
  }
}
