package Leetcode;

import Leetcode.SolBase;

public class Rand470 extends SolBase {

  /**Method1: Rejection Sampling; Time:O(1) - O(∞); Space:O(1) **/
  /**
   用拒绝采样的方法实现 Rand10()
   rand()7能等概率生成1~7,
   　　　rand7() - 1能等概率生成0~6,
   　　　(rand7() - 1) * 7能等概率生成{0, 7, 14, 21, 28, 35, 42},
   　　　(rand7() - 1) * 7 + rand7()能等概率生成1~49
   **/
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
  /**
   用拒绝采样的方法实现 Rand10()
   rand()7能等概率生成1~7,
   　　　rand7() - 1能等概率生成0~6,
   　　　(rand7() - 1) * 7能等概率生成{0, 7, 14, 21, 28, 35, 42},
   　　　(rand7() - 1) * 7 + rand7()能等概率生成1~49
   **/
  public int rand10() {
    int res, row;
    while(true) {
      row = rand7();
      res = (row -1) * 7 + rand7(); //rand7()每次调用的值都不同，故不要用变量来存
      if(res <= 40) {
        return res % 10 + 1; //大于 40 拒绝采样，

      }
      row = res - 40; //此时 res = rand9()
      res = (row - 1) * 7 + rand7(); // 8 * 7 + 7 = 63
      if(res <= 60) {
        return res % 10 + 1;   //大于 60 拒绝采样
      }
      row = res - 60;  //此时 res = rand3()
      res = (row - 1) * 7 + rand7();   // 2 * 7 + 7 = 21
      if(res <= 20) {
        return res % 10 +1;  //大于 20 拒绝采样
      }
    }
  }
}

class SolBase {
  int rand7() {
    return 0; //TODO
  };
}
