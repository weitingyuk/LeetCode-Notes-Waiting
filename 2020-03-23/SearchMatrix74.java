package Leetcode;

public class SearchMatrix74 {
  /**Method: Binary search; Time: O(log(row * col)); Space: O(1) **/
  public boolean searchMatrix(int[][] matrix, int target) { //通过把matrix当做线性表，拉直判断
    if(matrix == null || matrix[0] == null) {
      return false;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int s =0;
    int e = row*col -1;
    while(s<=e) {
      int mid = s+ (e-s)/2;
      if(matrix[mid/col][mid%col] == target) { //和列数做运算
        return true;
      } else if(matrix[mid/col][mid%col]  > target) {
        e = mid -1;
      } else {
        s = mid +1;
      }
    }
    return false;
  }
}
