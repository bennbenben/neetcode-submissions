class Solution {
  private int islandCount = 0;
  private char[][] grid;

  // BFS - Iterative (same as DFS Recursive, except for bfs method)
  public int numIslands(char[][] grid) {
    this.islandCount = 0;
    this.grid = grid;
    
    for (int x=0; x<this.grid.length; x++) {
      for (int y=0; y<this.grid[x].length; y++) {
        if (this.grid[x][y] == '1') { // found the first island, start iteration
          this.islandCount += 1;
          this.bfs(x, y, this.grid.length, this.grid[x].length);
        }
      }
    }
    return this.islandCount;
  }
  
  private void bfs(int x, int y, int xMax, int yMax) {
    
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.offer(new int[] {x, y});
    this.grid[x][y] = '0';    
    
    while (!queue.isEmpty()) {
      int numIslandsThisLevel = queue.size();
      
      for (int i=0; i<numIslandsThisLevel; i++) {
        int[] coordinates = queue.poll();
        int x1 = coordinates[0]; int y1 = coordinates[1];
        
        
        if (y1+1 < yMax && this.grid[x1][y1+1] == '1') {
          queue.offer(new int[] {x1, y1+1});
          this.grid[x1][y1+1] = '0';
        }
        
        if (y1-1 >= 0 && this.grid[x1][y1-1] == '1') {
          queue.offer(new int[] {x1, y1-1});
          this.grid[x1][y1-1] = '0';
        }
        
        if (x1+1 < xMax && this.grid[x1+1][y1] == '1') {
          queue.offer(new int[] {x1+1, y1});
          this.grid[x1+1][y1] = '0';
        }
        
        if (x1-1 >= 0 && this.grid[x1-1][y1] == '1') {
          queue.offer(new int[] {x1-1, y1});
          this.grid[x1-1][y1] = '0';
        }
      }
      
    }
  }
}
