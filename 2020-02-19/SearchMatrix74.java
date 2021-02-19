package Leetcode;

public class SearchMatrix74 {
  /**Method: Binary search; Time: O(log(row * col)); Space: O(1) **/
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if(row <=0) {
      return false;
    }
    int col = matrix[0].length;
    int start = 0;
    int end = row * col - 1;
    while(start<= end) {
      int mid = start + (end - start) /2;
      int val = matrix[mid /col][mid % col];
      if(val == target) {
        return true;
      } else if(target < val) {
        end = mid -1;
      } else{
        start = mid +1;
      }
    }
    return false;
  }
}
