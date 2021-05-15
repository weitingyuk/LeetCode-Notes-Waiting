package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStrChain1048 {
  /*Method: DP, Time: O(N^2), Space:O(N)**/
  /**
   对字符串数组排序，排序标准就是其长度，如果前面有一个字符串是后面一个字符串的实例。
   当往后遍历过程中可能有其他更长的情况，就要加上dp[j]=Math.max(dp[i]+1,dp[j])获取最大的值。
   最终在dp数组中就保存了每个字符串有多少个前身。
   **/
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    int len = words.length;
    int[] dp = new int[len];
    for(int i=0; i< len; i++){
      for(int j= i+1; j < len; j++) {
        if(isPredecessor(words[i], words[j])) {
          dp[j] = Math.max(dp[j], dp[i]+1);
        }
      }
    }
    int res =0;
    for(int i: dp){
      res = Math.max(i,res);
    }
    return res+1;//最终结果要+1。因为"a"是"ba"的前身，前身有一个，自己还算一个。
  }

  private boolean isPredecessor(String s1, String s2) {
    if(s2.length() - s1.length() != 1){
      return false;
    }
    int flag = 0;
    int i=0,j =0;
    while(i<s1.length() && j < s2.length()) {
      if(s1.charAt(i) == s2.charAt(j)) {
        i++;
        j++;
      } else {
        flag++;
        j++;
        if(flag>1){
          return false;
        }
      }
    }
    return true;
  }
}
