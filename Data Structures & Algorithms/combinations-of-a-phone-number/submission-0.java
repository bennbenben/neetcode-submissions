class Solution {
  // DFS - Recursive
  List<String> combinations = new ArrayList<String>();
  Map<Character, String> letterCombinationsMap = new HashMap<Character, String>();
  
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return this.combinations;
    }
    
    this.combinations.clear();
    
    this.letterCombinationsMap.put('2', "abc");
    this.letterCombinationsMap.put('3', "def");
    this.letterCombinationsMap.put('4', "ghi");
    this.letterCombinationsMap.put('5', "jkl");
    this.letterCombinationsMap.put('6', "mno");
    this.letterCombinationsMap.put('7', "pqrs");
    this.letterCombinationsMap.put('8', "tuv");
    this.letterCombinationsMap.put('9', "wxyz");
    
    StringBuilder currentSubset = new StringBuilder();
    
    this.dfs(0, digits, currentSubset);
    return this.combinations;
  }
  
  private void dfs(int digitIndex, String digits, StringBuilder sb) {
    if (digitIndex >= digits.length()) {
      this.combinations.add(sb.toString());
      return;
    }
    
    String letters = this.letterCombinationsMap.get(digits.charAt(digitIndex));
    
    for (int j=0; j<letters.length(); j++) {
      sb.append(letters.charAt(j));
      this.dfs(digitIndex+1, digits, sb);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
