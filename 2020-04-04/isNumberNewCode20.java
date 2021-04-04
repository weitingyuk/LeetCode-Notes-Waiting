package Leetcode;

public class isNumberNewCode20 {
  /**Time: O(N), Space: O(1) **/
  /**
   思路：
   1. 去空格
   2. 数字处理
   3. '.'之前不能有E/e
   4. '+'/'-' 只能出现在首位或者E/e后面
   5. 当前为E/e，之前没出现过，并且 之前要有数字 &&&& //防止e结尾 -》 numFlag= false
   **/
  public boolean isNumber(String s) {
    if(s == null || s.length() ==0) {
      return false;
    }
    s = s.trim(); //1. 去空格
    boolean numFlag = false;
    boolean dotFlag = false;
    boolean eFlag = false;
    for(int i =0; i<s.length(); i++) {
      if(s.charAt(i) >= '0' && s.charAt(i) <= '9') { // 2.比较数字
        numFlag = true;
      } else if(s.charAt(i) == '.' && !dotFlag && !eFlag) { // 3. '.'之前不能有E/e
        dotFlag = true;
      } else if(s.charAt(i) == '+' || s.charAt(i) == '-') { // 4. '+'/'-' 只能出现在首位或者E/e后面
        if(i!=0 && (s.charAt(i-1) != 'e' &&s.charAt(i-1) != 'E')) {
          return false;
        }
      } else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && numFlag&& !eFlag) { // 5. 当前为E/e，之前没出现过，并且 之前要有数字
        eFlag = true;
        numFlag= false; //防止e结尾
      } else {
        return false;
      }
    }
    return numFlag;
  }
}
