package Leetcode;

public class LongestPalindrome5 {

  /** Method1 : 暴力破解Brute Force，超时**/
  public String longestPalindrome0(String s) {
    int num = 0;
    String res = "";
    for(int i=0;i<s.length();i++) {
      for(int j=s.length()-1; j>=i;j--) {
        if(isPalindrome(s, i,j) && num < (j-i+1)) {
          num = j-i+1;
          res = s.substring(i,j+1);
        }
      }
    }
    return res;
  }

  private boolean isPalindrome(String s, int start, int end) {
    while(start < end) {
      if(s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start ++;
      end --;
    }
    return true;
  }

  /** Method2 : 中心扩展
   * 时间复杂度：O(N^2)
   * 空间复杂度：O(1)
   * **/
  public String longestPalindrome1(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    String res = s.substring(0, 1);
    // 中心位置枚举到 len - 2 即可
    for (int i = 0; i < len - 1; i++) {
      String oddStr = centerSpread(s, i, i);
      String evenStr = centerSpread(s, i, i + 1);
      String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
      if (maxLenStr.length() > maxLen) {
        maxLen = maxLenStr.length();
        res = maxLenStr;
      }
    }
    return res;
  }

  private String centerSpread(String s, int left, int right) {
    // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
    // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
    int len = s.length();
    int i = left;
    int j = right;
    while (i >= 0 && j < len) {
      if (s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
      } else {
        break;
      }
    }
    // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
    return s.substring(i + 1, j);
  }

}
