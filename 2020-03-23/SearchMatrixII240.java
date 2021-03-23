package Leetcode;

public class SearchMatrixII240 {
  /**Method1: Binary search with iterating on the diagonal; Time: O(lg(min(m,n) !)); Space: O(1) **/
  public boolean searchMatrix1(int[][] matrix, int target) {
    if(matrix == null || matrix[0] == null) {
      return false;
    }
    int shortLen = Math.min(matrix.length, matrix[0].length);
    for(int i=0; i < shortLen; i++) {
      boolean colFound = binSearch(matrix, i, target, true);
      boolean rowFound = binSearch(matrix, i, target, false);
      if(colFound || rowFound) {
        return true;
      }
    }
    return false;
  }

  private boolean binSearch(int[][] matrix, int num, int target, boolean isCol) {
    int s = num;
    int e = isCol? matrix[0].length-1: matrix.length-1;
    while(s <= e) {
      int mid = s + (e - s) /2;
      if(isCol) {
        if(matrix[num][mid] < target) {
          s = mid + 1;
        } else if(matrix[num][mid] > target) {
          e = mid-1;
        } else {
          return true;
        }
      } else {
        if(matrix[mid][num] < target) {
          s = mid + 1;
        } else if(matrix[mid][num] > target) {
          e = mid -1;
        } else {
          return true;
        }
      }
    }
    return false;
  }

  /**Method2: Binary search from c=0 and r = row-1; Time: O(m + n); Space: O(1) **/
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix[0] == null) {
      return false;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int r = 0;
    int c = col - 1;
    while(c>=0 && r <row) {
      if(matrix[r][c] == target) {
        return true;
      } else if(matrix[r][c] > target) {
        c--;
      } else if(matrix[r][c] < target)  {
        r++;
      }
    }
    return false;
  }
}
