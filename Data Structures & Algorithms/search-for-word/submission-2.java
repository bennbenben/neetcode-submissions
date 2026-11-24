class Solution {
  private Set<Coordinates> wordSet = new HashSet<Solution.Coordinates>();  
  private record Coordinates(int x, int y) {};
  
  public boolean exist(char[][] board, String word) {
    this.wordSet.clear();
    
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[i].length;j++) {
        if (this.dfs(0, board, word, i, j)) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  private boolean dfs(int wordIndex, char[][] board, String word, int x, int y) {
    if (wordIndex == word.length()) {
      return true;
    }
    
    if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
      return false;
    }
    
    boolean found = false;
    if (board[x][y] == word.charAt(wordIndex)) {
      Coordinates coordinate = new Coordinates(x, y);
      if (!this.wordSet.contains(coordinate)) {
        this.wordSet.add(coordinate);
        boolean right = this.dfs(wordIndex+1, board, word, x+1, y);
        boolean left = this.dfs(wordIndex+1, board, word, x-1, y);
        boolean up = this.dfs(wordIndex+1, board, word, x, y+1);
        boolean down = this.dfs(wordIndex+1, board, word, x, y-1);
        found = right || left || up || down;
        this.wordSet.remove(coordinate);
      } 
    }
    return found;
  }
}
