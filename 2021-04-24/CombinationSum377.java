package Leetcode;

public class CombinationSum377 {
  /**Method: DP; Time: O(target * N); Space: O(target) **/
  /**
   思路；
   用 dp[x] 表示选取的元素之和等于 x 的方案数，目标是求 dp[target]。
   动态规划的边界是 dp[0]=1。只有当不选取任何元素时，元素之和才为 0，因此只有 1 种方案。

   步骤：
   初始化 dp[0]=1；
   遍历 i 从 1 到 target，对于每个 i，进行如下操作：
   遍历数组 nums 中的每个元素 num，当 num≤i 时，将dp[i−num] 的值加到dp[i]。
   最终得到 dp[target] 的值即为答案。
   **/

  /**
   * *
   本题与「完全背包求方案数」问题的差别在于：选择方案中的不同的物品顺序代表不同方案。
   在「完全背包」问题中，凑成总价值为 6 的方案 [1,2,3] 算是 1 种方案，但在本题算是 3 * 2 * 1 = 6 种方案（[1,2,3],[2,1,3],[3,1,2] ... ）。
   因此我们不能直接代入「完全背包」的思路（状态定义）来求解。
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp =new int[target +1];
    dp[0] = 1;
    for(int i=1; i<=target;i ++) {
      for(int num:nums){
        if(num<=i) {
          dp[i] += dp[i-num];
        }
      }
    }
    return dp[target];
  }

}
