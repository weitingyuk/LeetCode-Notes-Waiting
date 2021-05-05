package Leetcode;

public class ReverseWords58 {
  /**Method: Two Pointers; Time:O(N); Space: O(N) **/
  public String reverseWords(String s) {
    s = s.trim(); // 删除首尾空格
    int j = s.length()-1, i=j;
    StringBuilder res = new StringBuilder();
    while(i>=0) {
      while(i >= 0 && s.charAt(i) != ' ') {// 搜索首个空格
        i--;
      }
      res.append(s.substring(i+1, j+1) + ' ');// 添加单词
      while(i>=0 && s.charAt(i) == ' ') {// 跳过单词间空格
        i--;
      }
      j=i;// j 指向下个单词的尾字符
    }
    return res.toString().trim();
  }

}
