class Solution {

  public String encode(List<String> strs) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : strs) {
      stringBuilder.append(str.length());
      stringBuilder.append("#");
      stringBuilder.append(str);
    }
    return stringBuilder.toString();
  }

  public List<String> decode(String str) {
    int i = 0, hexIndex = 0;
    List<String> result = new ArrayList<String>();

    // 3#abc5#abcde
    while (i < str.length()) {
      hexIndex = str.indexOf('#', i); // hexIndex=1
      int wordLength = Integer.valueOf(str.substring(i, hexIndex)); // wordLength=3
      String word = str.substring(hexIndex + 1, hexIndex + 1 + wordLength); // word = str.substring(1+1, 1+1+3)
      result.add(word);
      i = hexIndex + 1 + wordLength;
    }

    return result;
  }}
