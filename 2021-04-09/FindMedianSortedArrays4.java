package Leetcode;


public class FindMedianSortedArrays4 {
  /**Method: Mid number of the merged array; Time:O(N+M); Space: O(N+M) **/
  /**
   转化成寻找两个有序数组中的第 k 小的数，其中 k 为 (m+n)/2 或 (m+n)/2+1。
   **/
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 =nums2.length;
    int k1 =0, k2 =0, k=0;
    int[] nums = new int[l1+l2];
    while(k1 < l1 && k2 < l2) {
      if(nums1[k1] < nums2[k2]) {
        nums[k++] = nums1[k1++];
      } else{
        nums[k++] = nums2[k2++];
      }
    }
    while(k1 < l1) {
      nums[k++] = nums1[k1++];
    }
    while(k2 < l2) {
      nums[k++] = nums2[k2++];
    }
    if(k%2 ==1){
      return nums[k/2];
    }
    return (float)(nums[k/2-1] + nums[k/2])/2; //注意float
  }

}
