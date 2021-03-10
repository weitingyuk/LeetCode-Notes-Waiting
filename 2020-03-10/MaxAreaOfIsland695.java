package Leetcode;

public class MaxAreaOfIsland695 {

  /**Method: DFS; Time:O(R×C); Space: O(R×C) **/
  private int r, c;
  private int[][] direction = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
  public int maxAreaOfIsland(int[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }
    r = grid.length;
    c = grid[0].length;
    int maxArea = 0;
    for(int i=0;  i< r;i++) {
      for(int j=0; j< c; j++) {
        maxArea = Math.max(dfs(grid, i, j), maxArea);
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int i, int j){
    if(i<0 || i>=r || j<0 || j>= c || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    int area = 1;
    for(int[] d: direction) {
      area += dfs(grid, i+d[0], j+d[1]);
    }
    return area;
  }

}
