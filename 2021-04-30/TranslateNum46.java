package Leetcode;

public class TranslateNum46 {
  /**Method:substring; Method: O(N); Space:O(N) **/
  public int translateNum(int num) {
    String s = String.valueOf(num);
    int a=1,b=1;
    for(int i=s.length()-2; i>-1; i--){
      String tmp = s.substring(i, i+2);
      int c= tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a+b:a;
      b=a;
      a=c;
    }
    return a;
  }

}
