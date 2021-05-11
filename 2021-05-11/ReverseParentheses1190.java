package Leetcode;

public class ReverseParentheses1190 {
  /*Method: Two Pointers, Time: O(N), Space:O(N)**/
  public String reverseParentheses(String s) {
    char[] arr = s.toCharArray();
    int r = 0, l, len = s.length();
    while(r < len) {
      if(arr[r] != ')') {
        r += 1;
        continue;
      } else {
        l = r;
        while(arr[l] != '(') {
          l -= 1;
        }
        arr[l] = '0';
        arr[r] = '0';
        reverse(arr, l, r);
      }
    }
    StringBuilder res = new StringBuilder();
    for(int i=0; i< len; i++) {
      if(arr[i] != '0') {
        res.append(arr[i]);
      }
    }
    return res.toString();
  }

  public void reverse(char[] arr, int start, int end){
    while(start < end){
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start += 1;
      end -= 1;
    }
  }
}
