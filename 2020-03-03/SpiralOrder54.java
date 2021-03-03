package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {

  /* Method: Traversal by layer , Time: O(M*N), Space:O(1)**/
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if(matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }
    int left = 0;
    int right = matrix[0].length - 1;
    int up = 0;
    int down = matrix.length - 1;
    while(true) {
      for(int col = left; col <= right; col ++) {
        res.add(matrix[up][col]);
      }
      up++;
      if(up>down) {
        break;
      }
      for(int row = up; row <= down; row ++) {
        res.add(matrix[row][right]);
      }
      right--;
      if(right<left) {
        break;
      }
      for(int col = right; col >= left; col -- ) {
        res.add(matrix[down][col]);
      }
      down--;
      if(down < up) {
        break;
      }
      for(int row = down; row >= up; row --) {
        res.add(matrix[row][left]);
      }
      left++;
      if(left>right) {
        break;
      }
    }
    return res;
  }

}
