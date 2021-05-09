package Leetcode;

public class Transpose867 {
  /** Method: Mock; Time: O(MN);  Space:O(1);**/
  public int[][] transpose(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] trans = new int[n][m];
    for(int i=0; i< m; i++) {
      for(int j=0; j<n; j++) {
        trans[j][i] = matrix[i][j];
      }
    }
    return trans;
  }

}
