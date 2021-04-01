package Leetcode;

public class MinArray11 {
  /*Method: Binary search, Time: O(target), Space:O(1)**/
  /**
   当 nums[m] > nums[e]时： m 一定在 左排序数组 中，即旋转点 x 一定在 [m+1,e] 闭区间内，因此执行 s = m + 1；
   当 nums[m] < nums[e]时： m 一定在 右排序数组 中，即旋转点 x 一定在[s,m] 闭区间内，因此执行 e = m；
   当 nums[m] = nums[e]时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 x 在 [s, m]还是 [m + 1, e]区间中。解决方案： 执行 e = e - 1 缩小判断范围。
   **/
  public int minArray(int[] numbers) {
    int s=0,e=numbers.length-1;
    while(s<e) {
      int mid = s+(e-s)/2; // 和最大值numbers[e]作比较
      if(numbers[mid] < numbers[e]) {
        e = mid;
      } else if(numbers[mid] > numbers[e]) {
        s = mid + 1;
      } else {
        e -= 1; //执行 e = e - 1 缩小判断范围
      }
    }
    return numbers[s];
  }

}
