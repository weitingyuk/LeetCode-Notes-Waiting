package BasicKnowleage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacket1 {

  /**
   * 题目如下：为了避免抢红包时出现下图情况（即红包最大的和最小的差距非常大）微信程序员小萌打算修改红包算法，使抢到的红包最大和最小不超过 K 倍。
   * 公式化来说，输入为：红包总金额(sum)，红包数量(num)，K 共三个参数，设计算法使每一次输出的红包数组最大不超过最小值的 K 倍，并且要把红包随机发完。
   * 分配：微信红包里的金额怎么算？为什么出现各个红包金额相差很大？ 答：随机，额度在0.01和剩余平均值*2之间。 例如：发100块钱，总共10个红包，那么平均值是10块钱一个，那么发出来的红包的额度在0.01元～20元之间波动。
   * * 二倍均值法: *    红包剩余金额为 M *    红包剩余数量为 N *    这种算法就是每次都在区间[0,M/N×2] 随机取一个数
   */

  public static void main(String args[]) {
    List<Double> bList = doubleMeanMethod(100, 6, 5);
    System.out.println(String
        .format("mock(%s, %s, %s), the result：%s", 100, 6, 5, String.join(",", bList.toString())));
    double max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    double min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));
    System.out.println();

    bList = doubleMeanMethod(100, 1, 10);
    System.out.println(String
        .format("mock(%s, %s, %s), the result：%s", 100, 1, 10, String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));
    System.out.println();

    bList = doubleMeanMethod(100, 7, 1);
    System.out.println(String
        .format("mock(%s, %s, %s), the result：%s", 100, 7, 1, String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));
    System.out.println();

    bList = doubleMeanMethod(100, 37, 27);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 37, 27,
        String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));
    System.out.println();

    bList = doubleMeanMethod(100, 30, 10);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 30, 10,
        String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));
    System.out.println();

    bList = doubleMeanMethod(100, 75, 100);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 75, 100,
        String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s",
        format(bList.stream().mapToDouble(value -> value).sum()), max, min, format((double) (max / min))));

  }

  /**
   * 解题思路：
   * 1. max <= 2 * currentMoney / remainingNumber && max <= realMin(之前取到的最小min) * k
   * 2. min * K <= max && min <= realMax(之前取到的最小max) / k
   * 3. k=1的时候，需要额外处理； 使用重复取样法，保证后面的取值都能大于等于最小值
   */
  public static List<Double> doubleMeanMethod(double money, double number, double k) {
    List<Double> result = new ArrayList<Double>();
    if (money < 0 && number < 1) {
      return null;
    }
    double amount = 0;
    double remainingNumber = number;
    double real_min_total = Integer.MAX_VALUE;
    double real_max_total = Integer.MIN_VALUE;
    while (remainingNumber > 1) {
      double max_cur = k == 1 ? money / remainingNumber : Math.min(2 * money / remainingNumber, real_min_total * k);
      double min_cur = k == 1 ? max_cur : Math.max(real_max_total / k, max_cur / k);
      // Repeated sampling method
      do {
        amount = k == 1 ? format(max_cur) : nextDouble(min_cur, max_cur);
      } while ((money - amount) < min_cur * (remainingNumber - 1) - 1);
      if (amount < real_min_total) {
        real_min_total = amount;
      }
      if (amount > real_max_total) {
        real_max_total = amount;
      }
      money -= amount;
      remainingNumber--;
      result.add(amount);
    }
    result.add(format(money));
    return result;
  }

  public static double nextDouble(final double min, final double max) {
    return format(min + ((max - min) * new Random().nextDouble()));
  }

  public static double format(double value) {
    return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
  }

}
