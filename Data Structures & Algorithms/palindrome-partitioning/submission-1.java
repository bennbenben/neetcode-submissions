class Solution {
  // DFS - Recursive
  List<List<String>> partitions = new ArrayList<List<String>>();
  
  public List<List<String>> partition(String s) {
    this.partitions.clear();
    List<String> currentPartition = new ArrayList<String>();
    this.dfs(0, s, currentPartition);
    return this.partitions;
  }
  
  private void dfs(int index, String s, List<String> partition) {
    if (index >= s.length()) {
      this.partitions.add(new ArrayList<String>(partition));
      return;
    }
    
    for (int i=index; i<s.length(); i++) {
      String substr = s.substring(index, i+1);
      if (!this.isValidPalindrome(substr)) {
        continue;
      }
      
      partition.add(substr);
      this.dfs(i+1, s, partition);
      
      partition.remove(partition.size()-1);
    }
  }
  
  private boolean isValidPalindrome(String s) {
    int left=0; int right = s.length()-1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left += 1; right -= 1;
    }
    return true;
  }
}
