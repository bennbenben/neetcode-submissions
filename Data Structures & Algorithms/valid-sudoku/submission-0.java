class Solution {
    public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rowsMap = new HashMap<Integer, Set<Character>>();
    Map<Integer, Set<Character>> colsMap = new HashMap<Integer, Set<Character>>();
    Map<String, Set<Character>> boxMap = new HashMap<String, Set<Character>>();

    for (int i = 0; i < 9; i++) {

      Set<Character> rowsSet = rowsMap.get(i);
      if (rowsSet == null) {
        rowsSet = new HashSet<Character>();
        rowsMap.put(i, rowsSet);
      }

      for (int j = 0; j < 9; j++) {
        
        if (board[i][j] == '.') {
          continue;
        }

        Set<Character> colsSet = colsMap.get(j);
        if (colsSet == null) {
          colsSet = new HashSet<Character>();
          colsMap.put(j, colsSet);
        }

        int boxRow = i / 3;
        int boxCol = j / 3;
        String boxMapKey = boxRow + "," + boxCol;

        Set<Character> boxSet = boxMap.get(boxMapKey);
        if (boxSet == null) {
          boxSet = new HashSet<Character>();
          boxMap.put(boxMapKey, boxSet);
        }

        if (rowsSet.contains(board[i][j]) || colsSet.contains(board[i][j]) || boxSet.contains(board[i][j])) {
          return false;
        }

        rowsSet.add(board[i][j]);
        colsSet.add(board[i][j]);
        boxSet.add(board[i][j]);

      }

    }

    return true;
  }
}
