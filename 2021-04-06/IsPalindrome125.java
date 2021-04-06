package Leetcode;

public class IsPalindrome125 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  /**
   * 重点：Character.isLetterOrDigit & Character.toLowerCase
   思路：
   1.若前指针遇到不是字母或数字的元素则向后移动，若后指针碰到不是字母或数字的元素则后指针向前移动。
   2.若尾指针在头指针之前则遍历结束，字符串是回文串
   3.若指针指向的元素符合规则但是不相等则不是回文串
   **/
  public boolean isPalindrome(String s) {
    int l =0;
    int h=s.length()-1;
    while(l<h) {
      while(l<h && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while(l<h && !Character.isLetterOrDigit(s.charAt(h))) {
        h--;
      }
      if(l<h ) {
        if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(h))) {
          return false;
        }
        l++;
        h--;
      }
    }
    return true;
  }

}
