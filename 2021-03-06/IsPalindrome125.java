package Leetcode;

public class IsPalindrome125 {
  /*Method : Two pointers, Time: O(N), Space:O(1)**/
  public boolean isPalindrome(String s) {
    int len = s.length();
    int left = 0;
    int right = len-1;
    while(left< right) {
      while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if(left < right){
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
          return false;
        }
        left++;
        right--;
      }
    }
    return true;
  }

}
