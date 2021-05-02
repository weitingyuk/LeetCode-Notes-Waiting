package Leetcode;

public class GenerateMatrix59 {

  /**Method:Mock; Time:O(N^2); Space: O(1) **/
  public int[][] generateMatrix(int n) {
    int l=0, r=n-1, t=0,b=n-1;
    int[][] matrix = new int[n][n];
    int num = 1, tar = n * n;

    while(num <= tar) {
      for(int i=l; i<=r; i++) {
        matrix[t][i] = num++;
      }
      t++;
      for(int i=t; i<=b; i++) {
        matrix[i][r] = num++;
      }
      r--;
      for(int i=r; i>=l; i--) {
        matrix[b][i] = num++;
      }
      b--;
      for(int i=b; i>=t; i--) {
        matrix[i][l] = num++;
      }
      l++;
    }
    return matrix;
  }
}
