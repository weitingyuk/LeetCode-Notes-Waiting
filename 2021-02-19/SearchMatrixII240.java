package Leetcode;

public class SearchMatrixII240 {
  /**Method1: Binary search with iterating on the diagonal; Time: O(lg(min(m,n) !)); Space: O(1) **/
  public boolean searchMatrix1(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0) { return false;  }
    int shorterDim = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i < shorterDim; i++) {
      boolean colFound = binarySearch(matrix, target, i, true);
      boolean rowFound = binarySearch(matrix, target, i, false);
      if(rowFound || colFound) {    return true;    }
    }
    return false;
  }
  private boolean binarySearch(int[][] matrix, int target, int num, boolean isColSearch) {
    int start = num;
    int end = isColSearch ? matrix[0].length-1 : matrix.length-1;
    while (end >= start) {
      int mid = (start + end)/2;
      if (isColSearch) {
        if (matrix[num][mid] < target) {
          start = mid + 1;
        } else if (matrix[num][mid] > target) {
          end = mid - 1;
        } else {
          return true;
        }
      } else {
        if (matrix[mid][num] < target) {
          start = mid + 1;
        } else if (matrix[mid][num] > target) {
          end = mid - 1;
        } else {
          return true;
        }
      }
    }
    return false;
  }
  /**Method2: Binary search from c=0 and r = row-1; Time: O(m + n); Space: O(1) **/
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0) { return false;  }
    int row = matrix.length;
    int col = matrix[0].length;
    int r = row-1;
    int c = 0;
    while (r >= 0 && c < col) {
      if(matrix[r][c] == target) {
        return true;
      } else if(matrix[r][c] < target) {
        c++;
      } else if(matrix[r][c] > target) {
        r--;
      }
    }
    return false;
  }
}
