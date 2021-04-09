package Leetcode;

public class Reverse7 {
  /**Method: / & %; Time:O(N) - N is digit number; Space: O(1) **/
  public int reverse(int x) {
    int ans = 0;
    while(x != 0) {
      if((ans*10) /10 != ans ) { // 判断 ans*10 是否溢出，ans*10未溢出时, ans*10个位为0, x%10的取值范围是0~9, 故ans*10 + x%10一定没有进位, 故不会溢出。
        return 0;
      }
      ans = ans * 10 + x%10;
      x =x /10;
    }
    return ans;
  }

}
