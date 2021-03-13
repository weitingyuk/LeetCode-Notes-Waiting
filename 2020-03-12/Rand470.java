package Leetcode;

import Leetcode.SolBase;

public class Rand470 extends SolBase {

  /**Method1: Rejection Sampling; Time:O(1) - O(∞); Space:O(1) **/
  /*

  为什么？ (rand7()−1)∗7+rand7()

  1. 首先 rand7()-1得到的数的集合为 { 0,1,2,3,4,5,6}

  2. 再乘 7 后得到的集合 A 为 { 0，7，14，21，28，35，42}

  3. 后面 rand7() 得到的集合B为 { 1,2,3,4,5,6,7}
*/
  public int rand10_1() {
    int row, col, res;
    do {
      row = rand7();
      col = rand7();
      res = (row -1) * 7 + col;
    } while(res > 40);
    return (res -1) % 10 + 1;
  }

  /**Method2: Rejection Sampling By Use Rejection Sampling; Time:O(1) - O(∞); Space:O(1) **/
  public int rand10_2() {
    int row, col, res;
    while(true) {
      row = rand7();
      col = rand7();
      res = (row -1) * 7 + col;
      if (res <= 40) {
        return (res -1) % 10 + 1;
      }

      row = res - 40;
      col = rand7();
      // get uniform dist from 1 - 63
      res = (row - 1) * 7 + col;
      if (res <= 60) {
        return (res -1) % 10 + 1;
      }

      row = res - 60;
      col = rand7();
      // get uniform dist from 1 - 21
      res = (row - 1) * 7 + col;
      if (res <= 20) {
        return (res -1) % 10 + 1;
      }
    }
  }
}

class SolBase {
  int rand7() {
    return 0; //TODO
  };
}
