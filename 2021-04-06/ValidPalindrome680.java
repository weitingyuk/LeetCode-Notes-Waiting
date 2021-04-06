package Leetcode;

public class ValidPalindrome680 {
  /**Method: Greedy + Two pointers ; Time:O(N); Space: O(1) **/
  /**
   思路：定义左右指针，初始时分别指向字符串的第一个字符和最后一个字符，每次判断左右指针指向的字符是否相同：
   如果相同，则将左右指针都往中间移动一位，直到左右指针相遇，则字符串是回文串。
   如果两个指针指向的字符不同，则两个字符中必须有一个被删除：（因为允许最多删除一个字符）
   1. 删除左指针对应的字符，留下子串 [l+1,h]
   2. 删除右指针对应的字符，留下子串 [l+1,h-1]
   **/
  public boolean validPalindrome(String s) {
    int l = 0,h=s.length()-1;
    while(l<h) {
      char c1 = s.charAt(l);
      char c2 = s.charAt(h);
      if(c1 == c2) {
        l++;
        h--;
      } else {
        return validPalindrome(s, l+1, h) || validPalindrome(s, l, h-1);
      }
    }
    return true;
  }

  private boolean validPalindrome(String s, int l, int h) {
    for(int i=l,j=h;i<j;i++,j--) {
      if(s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

}
