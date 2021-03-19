package Leetcode;

public class SpiralOrder29 {
  /* Method: Traversal by layer , Time: O(M*N), Space:O(1)**/
  public int[] spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }

    int[] res = new int[matrix[0].length * matrix.length ];
    int left = 0;
    int right = matrix[0].length - 1;
    int up = 0;
    int down = matrix.length - 1;
    int index = 0;
    while(true) {
      for(int col = left; col <= right; col ++) {
        res[index++] =matrix[up][col];
      }
      up++;
      if(up>down) {
        break;
      }
      for(int row = up; row <= down; row ++) {
        res[index++] =matrix[row][right];
      }
      right--;
      if(right<left) {
        break;
      }
      for(int col = right; col >= left; col -- ) {
        res[index++] = matrix[down][col];
      }
      down--;
      if(down < up) {
        break;
      }
      for(int row = down; row >= up; row --) {
        res[index++] = matrix[row][left];
      }
      left++;
      if(left>right) {
        break;
      }
    }
    return res;
  }

}
