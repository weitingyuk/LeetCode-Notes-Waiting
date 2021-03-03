package Leetcode;

public class ReOrderArrayNewCode {
  /* Method: Bubble , Time: O(N^2), Space:O(1)**/
  public int[] reOrderArray (int[] array) {
    if(array == null || array.length == 0) {
      return new int[0];
    }
    int len = array.length;
    boolean changed = true;
    for(int i = len-1 ; i >=0 && changed; i--) {
      changed =false;
      for(int j=0; j< i; j++) {
        if(array[j+1] % 2 > array[j] % 2) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
          changed = true;
        }
      }
    }
    return array;
  }
}
