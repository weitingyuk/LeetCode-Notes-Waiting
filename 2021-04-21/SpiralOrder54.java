package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
  /* Method: Traversal by layer , Time: O(M*N), Space:O(1)**/
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if(matrix == null || matrix.length ==0 || matrix[0].length ==0) {
      return res;
    }
    int rs = matrix.length, cs = matrix[0].length;
    int l = 0, r=cs-1, t=0,b=rs-1; //b=rs-1
    while(l<=r && t<=b){
      for(int col = l; col<=r; col++) {
        res.add(matrix[t][col]);
      }
      for(int row = t+1; row<=b;row++) {
        res.add(matrix[row][r]);
      }
      if(l<r && t<b) { //再次判断
        for(int col = r-1; col > l; col--) {
          res.add(matrix[b][col]);
        }
        for(int row = b; row > t; row--) {
          res.add(matrix[row][l]);
        }
      }
      l++;
      r--;
      t++;
      b--;
    }
    return res;
  }

}
