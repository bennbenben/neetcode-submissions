class Solution {
  // DFS - Recursive
  List<List<String>> nQueens = new ArrayList<List<String>>();
  
  public List<List<String>> solveNQueens(int n) {
    this.nQueens.clear();
    Set<Coordinates> coordinatesSet = new HashSet<Solution.Coordinates>(); 
    this.dfs(0, n, coordinatesSet);
    return this.nQueens;
  }
  
  private void dfs(int x, int n, Set<Coordinates> coordinatesSet) {
    if (coordinatesSet.size() == n) {
      this.nQueens.add(this.createBoardFromCoordinatesSet(coordinatesSet, n));
      return;
    }
    
    for (int y=0; y<n; y++) {
      if (this.isValidCoordinatesSet(x, y, coordinatesSet)) {
        Coordinates coordinate = new Coordinates(x, y);
        coordinatesSet.add(coordinate);
        this.dfs(x+1, n, coordinatesSet);
        coordinatesSet.remove(coordinate);
      } else {
        continue;
      }
    }
    
  }
  
  private record Coordinates(int x, int y) {};
  
  private boolean isValidCoordinatesSet(int x, int y, Set<Coordinates> coordinatesSet) {
    for (Coordinates validCoordinate : coordinatesSet) {
      // check is there any on the same row or same column
      if (validCoordinate.x == x || validCoordinate.y == y) {
        return false;
      }
      
      // check is there any on the same diagonal
      if (Math.abs(validCoordinate.x - x) == Math.abs(validCoordinate.y - y)) {
        return false;
      }
    }
    return true;
  }
  
  private List<String> createBoardFromCoordinatesSet(Set<Coordinates> coordinatesSet, int n) {
    List<String> board = new ArrayList<String>();
    for (int x=0; x<n; x++) {
      StringBuilder sbRow = new StringBuilder();
      for (int y=0; y<n; y++) {
        if (coordinatesSet.contains(new Coordinates(x, y))) {
          sbRow.append("Q"); // or 'Q' to append primitive char instead of String
        } else {
          sbRow.append("."); // or '.' to append primitive char instead of String
        }
      }
      board.add(sbRow.toString());
    }
    return board;
  }
}
