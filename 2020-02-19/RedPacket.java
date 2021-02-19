package BasicKnowleage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RedPacket1 {
  public static void main(String args[])  {
    List<Double> bList = createBonusList(100, 6, 5);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 6, 5 ,String.join(",", bList.toString())));
    double max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    double min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));
    System.out.println();

    bList = createBonusList(100, 1, 10);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 1, 10 ,String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));
    System.out.println();

    bList = createBonusList(100, 7, 1);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 7, 1 ,String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));
    System.out.println();

    bList = createBonusList(100, 37, 27);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 37, 27 ,String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));
    System.out.println();

    bList = createBonusList(100, 30, 10);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 30, 10 ,String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));
    System.out.println();

    bList = createBonusList(100, 75, 100);
    System.out.println(String.format("mock(%s, %s, %s), the result：%s", 100, 75, 100,String.join(",", bList.toString())));
    max = bList.stream().mapToDouble(value -> value).max().getAsDouble();
    min = bList.stream().mapToDouble(value -> value).min().getAsDouble();
    System.out.println(String.format("The end total num： %s; Max: %s;  Min: %s; Max times: %s", bList.stream().mapToDouble(value -> value).sum(), max, min, (int) (max/min)));

  }
  
  //考虑到最极端的情况totalNum-1个都是取值min，只有一个取到max,这时候max能取到最大值, 这种情况能得出对应的min和最大的max, 即
  // max = k * min;
  // sum = (totalNum-1)*min + k * min = (k + totalNum - 1) * min
  public static List<Double> createBonusList(double totalBonus, double totalNum, double k) {
    double sentBonus = 0;
    double sentNum = 0;

    //double rdMin = Math.max(totalBonus / (k * (totalNum - 1) + 1), 0.01); //The floor
    double rdMin = Math.max(totalBonus / (k + totalNum - 1), 0.01); //The floor
    double rdMax = rdMin * k; // The ceil
    System.out.println("The range is："+ rdMin+"," + rdMax);
    List<Double> bonusList = new ArrayList<>();
    while (sentNum < totalNum) {
      double bonus = randomRedPacketWithBound(totalBonus, totalNum, sentBonus, sentNum, rdMin, rdMax);
      bonusList.add(bonus);
      sentNum++;
      sentBonus += bonus;
    }
    return bonusList;
  }

  private static double randomRedPacketWithBound(double totalBonus, double totalNum, double sentBonus,
      double sentNum, double rdMin, double rdMax) {
    double boundMin = Math.max((totalBonus - sentBonus - (totalNum - sentNum - 1) * rdMax), rdMin);
    double boundMax = Math.min((totalBonus - sentBonus - (totalNum - sentNum - 1) * rdMin), rdMax);
    //System.out.println("The range is："+ boundMin+"," + boundMax);
    return nextDouble(boundMin,boundMax);
  }
  public static double nextDouble(final double min, final double max) {
    return format(min + ((max - min) * new Random().nextDouble()));
  }
  public static double format(double value) {
    return new BigDecimal(value).setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
  }

}
