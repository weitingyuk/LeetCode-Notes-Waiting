package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex528 {
  /** Method:Prefix Sum + Bin Search, Time: O(N), Space:O(N)**/
  /**
   求出前缀和数组 p和总数sum
   在范围 [0, p和总数sumt) 中随机选择一个整数 ran。
   使用二分查找来找到下标 x，其中 x 是满足 ran<p[x] 的最小下标。
   **/
  List<Integer> psum = new ArrayList<>();
  int sum=0;
  Random rand = new Random();
  public RandomPickIndex528(int[] w) {
    for(int x:w){
      sum+=x;
      psum.add(sum);
    }
  }

  public int pickIndex() {
    int tag = rand.nextInt(sum);
    int s =0, e= psum.size()-1;
    while(s<e){
      int mid = s+(e-s)/2;
      if(tag >= psum.get(mid)) {
        s = mid+1;
      } else {
        e = mid;
      }
    }
    return s;
  }

}
