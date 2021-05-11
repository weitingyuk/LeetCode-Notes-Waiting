package Leetcode;

public class PeakIndexInMountainArray852 {

  /*Method: Binary Search, Time: O(LogN), Space:O(1)**/
  public int peakIndexInMountainArray(int[] arr) {
    int l = 0, h= arr.length-1;
    while(l<h){
      int mid = l +(h-l)/2;
      if(arr[mid] < arr[mid + 1]) {
        l = mid+1;
      } else {
        h = mid;
      }
    }
    return l;
  }
}
