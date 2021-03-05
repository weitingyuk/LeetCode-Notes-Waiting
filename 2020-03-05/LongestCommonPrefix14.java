package Leetcode;

public class LongestCommonPrefix14 {
  /*Method : Compare two strings one by one, Time: O(M*N), Space:O(1)**/
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0) {
      return "";
    }
    String prefix = strs[0];
    int count = strs.length;
    for(int i = 1; i < count; i ++) {
      prefix = longestCommonPrefix(prefix, strs[i]);
      if(prefix.length() == 0) {
        break;
      }
    }
    return prefix;
  }

  public String longestCommonPrefix(String str1, String str2) {
    int minLen = Math.min(str1.length(), str2.length());
    int index = 0 ;
    while(index < minLen&&str1.charAt(index) == str2.charAt(index)){
      index++;
    }
    return str1.substring(0, index);
  }
}
