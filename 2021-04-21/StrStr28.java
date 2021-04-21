package Leetcode;

public class StrStr28 {
  /**Method: Force; Time:O(N*M); Space:O(1) **/
  public int strStr(String haystack, String needle) {
    int n = haystack.length();
    int m = needle.length();
    for(int i=0;i<=n-m; i++) { // i<=n-m
      boolean flag = true;
      for(int j=0; j<m;j++){
        if(haystack.charAt(i+j) != needle.charAt(j)) { //i+j
          flag = false;
          break;
        }
      }
      if(flag){
        return i;
      }
    }
    return -1;
  }
}
