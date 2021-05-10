package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {
  /** Method:Stack; Time: O(N);  Space:O(N);**/
  /**
   维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
   如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
   正向遍历温度列表。
   对于温度列表中的每个元素 T[i]，如果栈为空，则直接将 i 进栈
   如果栈不为空，则比较栈顶元素 prevIndex 对应的温度 T[prevIndex] 和当前温度 T[i]
   如果 T[i] > T[prevIndex]，则将 prevIndex 移除，并将 prevIndex 对应的等待天数赋为 i - prevIndex，重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈。
   **/
  public int[] dailyTemperatures(int[] T) {
    int len = T.length;
    int[] ans = new int[len];
    Deque<Integer> stack = new LinkedList<Integer>();
    for(int i=0; i<len; i++) {
      int temp = T[i];
      while(!stack.isEmpty() && temp > T[stack.peek()]) {
        int preIndex = stack.pop();
        ans[preIndex] = i- preIndex;
      }
      stack.push(i);
    }
    return ans;
  }

}
