class Solution {
  // DFS - recursive with passing down count of ( and )
  List<String> parenthesis = new ArrayList<String>();
  
  public List<String> generateParenthesis(int n) {
    this.parenthesis.clear();
    if (n==0) {
      return this.parenthesis;
    }
    StringBuilder currentSubset = new StringBuilder();
    this.dfsRecursiveParenthesis(0, 0, currentSubset, n);
    return this.parenthesis;
  }
  
  private void dfsRecursiveParenthesis(int open, int close, StringBuilder subset, int n) {
    // terminal condition - when open == close == n
    if (open == n && close == n) {
      this.parenthesis.add(subset.toString());
      return;
    }
    
    // terminal condition - invalid parenthesis when # close > # open brackets; and # open > n
    if (close > open || open > n) {
      return;
    }
    
    // parenthesis string is still valid
    subset.append("(");
    this.dfsRecursiveParenthesis(open+1, close, subset, n);
    subset.deleteCharAt(subset.length()-1);
    
    subset.append(")");
    this.dfsRecursiveParenthesis(open, close+1, subset, n);
    subset.deleteCharAt(subset.length()-1);
  }
}
