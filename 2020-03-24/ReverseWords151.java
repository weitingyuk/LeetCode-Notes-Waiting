package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords151 {
  /**Method1: Use Java Methods; Time: O(N); Space: O(N) **/
  public String reverseWords(String s) {
    s = s.trim();
    List<String> words = Arrays.asList(s.split("\\s+")); //1. 空格正则\\s+
    Collections.reverse(words); //2. Collections.reverse
    return String.join(" ", words);
  }

  /**Method2: Implemented Methods; Time: O(N); Space: O(N) **/
  public String reverseWords2(String s) {
    StringBuilder sb = trimSpace(s);
    reverse(sb, 0, sb.length() - 1);
    reverseEachWords(sb);
    return sb.toString();
  }
  private StringBuilder trimSpace(String s) {
    int start = 0, end = s.length()-1;
    while(start<= end && s.charAt(start) == ' ') {
      start++;
    }
    while(start<=end && s.charAt(end) == ' ') {
      end --;
    }
    StringBuilder sb = new StringBuilder();
    while(start <= end) {
      char c = s.charAt(start);
      if(c != ' ' || (sb.charAt(sb.length() - 1) != ' ')){
        sb.append(c);
      }
      start ++;
    }
    return sb;
  }
  private void reverseEachWords(StringBuilder sb){
    int len = sb.length();
    int start = 0;
    int end = 0;
    while(start < len) {
      while(end < len && sb.charAt(end) != ' '){
        end ++;
      }
      reverse(sb, start, end-1);
      start = end+1;
      end ++;
    }
  }
  private void reverse(StringBuilder sb, int start, int end) {
    while (start < end) {
      char temp = sb.charAt(start);
      sb.setCharAt(start, sb.charAt(end));
      sb.setCharAt(end, temp);
      start ++;
      end --;
    }
  }


}
