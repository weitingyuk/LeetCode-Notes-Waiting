package Leetcode;

public class CanCompleteCircuit134 {
  /**Method:Iterator; Time:O(N); Space: O(1) **/
  /**
   从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
   我们首先检查第 0 个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。
   **/
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int i=0;
    while(i<n) {
      int sumGas = 0, sumCost = 0;
      int cnt = 0;
      while(cnt < n) { // 退出循环的条件是走过所有的站点
        int j= (i+cnt) % n; // 加油站是环形的
        sumGas += gas[j];
        sumCost += cost[j];
        if(sumCost > sumGas) { // 如果这个站点发现油不够了
          break;
        }
        cnt++;
      }
      if(cnt == n) { // 如果能环绕一圈
        return i;
      } else {// 不行的话，从第一个无法到达的加油站开始继续检查。
        i += cnt + 1;
      }
    }
    return -1;
  }

}
