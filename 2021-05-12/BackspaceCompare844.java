package Leetcode;

public class BackspaceCompare844 {
  /*Method:Two Pointer, Time: O(M+N), Space:O(1)**/
  /**
   一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
   我们定义 Skip 表示当前待删除的字符的数量。每次我们遍历到一个字符：
   若该字符为退格符，则我们需要多删除一个普通字符，我们让 kip 加 1；
   若该字符为普通字符：
   若 skip 为 0，则说明当前字符不需要删去；
   若 skip 不为 0，则说明当前字符需要删去，我们让 skip 减 1。
   **/
  public boolean backspaceCompare(String s, String t) {
    int i=s.length()-1, j=t.length()-1;
    int skipS = 0, skipT =0;
    while(i >= 0 || j >= 0) {
      while(i >= 0) {
        if (s.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }
      while (j >= 0) {
        if (t.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else {
          break;
        }
      }
      if (i >= 0 && j >= 0) {
        if (s.charAt(i) != t.charAt(j)) {
          return false;
        }
      } else {
        if (i >= 0 || j >= 0) {
          return false;
        }
      }
      i--;
      j--;
    }
    return true;
  }

}
