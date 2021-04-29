package Leetcode;

public class ReverseLeftWords58 {

  /**Method1:Substring; Method: O(N); Space:O(N) **/
  public String reverseLeftWords(String s, int n) {
    return s.substring(n, s.length()) + s.substring(0,n);
  }

  /**Method2:StringBuilder + charAt(%); Method: O(N); Space:O(N) **/
  /**
   新建一个 StringBuilder(Java) ，记为 res ；
   先向 res 添加 “第 n + 1位至末位的字符” ；
   再向 res 添加 “首位至第 n 位的字符” ；
   将 res 转化为字符串并返回。
   **/
  public String reverseLeftWords2(String s, int n) {
    StringBuilder res = new StringBuilder();
    for(int i=n; i<n+s.length(); i++) {
      res.append(s.charAt(i%s.length()));
    }
    return res.toString();
  }

}
