package Leetcode;

public class Rotate48 {
  /**Method: Flip instead of rotate; Time: O(N^2), Space: O(1) **/
  /**
   思路： 先水平翻转，再主对角线翻转
   **/
  public void rotate(int[][] matrix) {
    int n=matrix.length;
    for(int i=0;i<n/2;i++) { //水平轴翻转,i<n/2,只需要枚举矩阵上半部分的元素，和下半部分的元素进行交换
      for(int j=0; j<n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-i-1][j]; // n-i-1: 当i=0时，水平轴翻转后为n-1;
        matrix[n-i-1][j] = temp;
      }
    }
    for(int i=0;i<n;i++) {
      for(int j=0; j<i; j++) { // 主对角线翻转，j<i,只需要枚举对角线左侧的元素，和右侧的元素进行交换
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i]; //主对角线翻转
        matrix[j][i] = temp;
      }
    }

  }

}
