package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class Permutation38 {
  /*Method: BackTrack, Time: O(N*N!), Space:O(N)**/
  Set<String> res = new HashSet<>();
  boolean[] visited;
  public String[] permutation(String str) {
    if(str==null){
      return new String[]{};
    }
    int len = str.length();
    visited=new boolean[len];
    backtracking(str,"");
    return res.toArray(new String[len]);
  }
  private void backtracking(String s,String letter){
    if(s.length() == letter.length()) {
      res.add(letter);
      return;
    }
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(visited[i]) {
        continue;
      }
      visited[i] = true;
      backtracking(s, letter+c);
      visited[i] = false;
    }
  }

}
