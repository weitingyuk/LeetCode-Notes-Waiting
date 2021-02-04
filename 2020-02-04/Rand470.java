package Leetcode;

import Leetcode.SolBase;

public class Rand470 extends SolBase {

  /**Method1: Rejection Sampling; Time:O(1) - O(∞); Space:O(1) **/
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
