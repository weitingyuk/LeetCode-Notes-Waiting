package Leetcode;

public class UniquePathsII63 {
  /*Method: DP, Time: O(N^M), Space:O(M)**/
  /**
   如果坐标(i,j) 有障碍物，obstacleGrid(i,j)=0，否则 obstacleGrid(i, j) = 1。
   思路： f(i, j)来表示从坐标 (0, 0)到坐标 (i, j)的路径总数
   f(i, j) 只能通过 f(i - 1, j) 和 f(i, j - 1)转移得到
   **/
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    int[] f= new int[m];

    f[0] = obstacleGrid[0][0] == 1?0:1; //注意：obstacleGrid[0][0]可能会有障碍
    for(int i=0;i<n;i++) {
      for(int j = 0; j<m;j++) {
        if(obstacleGrid[i][j] == 1) {
          f[j] = 0;
          continue;
        }
        if(j>0 && obstacleGrid[i][j-1] ==0) {
          f[j] += f[j-1];
        }
      }
    }
    return f[m-1];
  }
}
