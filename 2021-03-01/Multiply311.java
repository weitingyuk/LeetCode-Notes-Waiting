package Leetcode;

import java.util.ArrayList;

public class Multiply311 {

  /**Method: Using array to save sparse values; Time: O(Ra*Ca)+O(Rb*Cb)+O(La*Lb); Space:O(R*C + L), L is the number of non-zero elements**/
  public int[][] multiply(int[][] A, int[][] B) {
    ArrayList<ArrayList<Integer>> arrayA = new ArrayList<>();
    ArrayList<ArrayList<Integer>> arrayB = new ArrayList<>();
    int rowB = B.length;
    int colB = B[0].length;
    int rowA = A.length;
    int colA = A[0].length;

    int[][] res = new int[rowA][colB];
    for(int row=0; row<rowA; row++) {
      ArrayList<Integer> colIndex = new ArrayList<>();
      for(int col =0; col< colA; col++) {
        if(A[row][col] != 0) {
          colIndex.add(col);
        }
      }
      arrayA.add(colIndex);
    }
    for(int col=0; col<colB; col++) {
      ArrayList<Integer> rowIndex = new ArrayList<>();
      for(int row =0; row< rowB; row++) {
        if(B[row][col] != 0) {
          rowIndex.add(row);
        }
      }
      arrayB.add(rowIndex);
    }
    for(int row=0; row<rowA; row++) {
      for(int col=0; col<colB; col++) {
        int valA = 0;
        int valB = 0;
        while(valA < arrayA.get(row).size() && valB < arrayB.get(col).size()) {
          if(arrayA.get(row).get(valA) == arrayB.get(col).get(valB)) {
            res[row][col] += A[row][arrayA.get(row).get(valA)] * B[arrayB.get(col).get(valB)][col];
            valA++;
            valB++;
          }
          else if(arrayA.get(row).get(valA) < arrayB.get(col).get(valB)){
            valA++;
          }
          else {
            valB++;
          }
        }
      }
    }
    return res;
  }

}
