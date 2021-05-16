package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsRectangleCover391 {
  /*Method: Coordinate ablation, Time: O(N), Space:O(N)**/
  /**
   解决这个问题，需要进行以下四个判断：
   1. 所有小矩形的面积之和，等于最终形成的大矩形的面积，若不是，则不能形成完美矩形；
   2. 遍历小矩形，判断其四个顶点的坐标，是否在已访问坐标集合中，若是，则移除这个坐标（即为消融）；若不是，则将这些顶点坐标加入到已访问坐标集合中；
   3. 最终如果能够形成完美矩形，那么已访问坐标集合中只能有四个元素，若集合中元素不是四个，则不能形成完美矩形；
   4. 判断最终形成的大矩形，其四个顶点是否就是已访问坐标集合中的四个元素，若是，则找到完美矩形。
   **/
  public boolean isRectangleCover(int[][] rectangles) {
    // 最终坐标的左下角和右上角坐标
    int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
    int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

    int areas = 0;
    Set<String> points = new HashSet<>();
    for(int[] rectangle: rectangles) {
      int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];

      X1 = Math.min(x1, X1);
      Y1 = Math.min(y1, Y1);
      X2 = Math.max(x2, X2);
      Y2 = Math.max(y2, Y2);

      areas += (x2-x1) * (y2 - y1);
      // 判断顶点是否出现过
      String[] ps = {x1 + " " + y1, x2+ " " + y2, x1 + " "+ y2, x2+ " "+ y1};
      for(String s: ps) {
        if(points.contains(s)) {
          points.remove(s);
        } else {
          points.add(s);
        }
      }
    }
    // 面积是否相等
    int expected = (X2 - X1) * (Y2 - Y1);
    if(areas != expected) {
      return false;
    }
    // 顶点情况是否满足
    if(points.size() != 4 || !points.contains(X1+" "+Y1) || !points.contains(X2+" "+Y2) || !points.contains(X1+" "+Y2) || !points.contains(X2+" "+Y1)) {
      return false;
    }
    return true;
  }

}
