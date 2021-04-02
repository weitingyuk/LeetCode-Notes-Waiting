package Leetcode;

public class Search81 {
  /*Method: Binary Search, Time: O(N), Space:O(1)**/
  public boolean search(int[] nums, int target) {
    int len = nums.length;
    int s =0, e = len-1;
    while(s <= e) {
      int mid = s+(e-s)/2;
      if(nums[mid] == target) {
        return true;
      }

      if(nums[s] == nums[mid]) { // 分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
        s ++;
        continue;
      }
      if(nums[s] <= nums[mid]) {
        if(nums[s] <= target && target < nums[mid]) { //nums[mid] <=target
          e= mid-1;
        } else {
          s = mid+1;
        }
      } else {
        if(nums[mid] < target && target <= nums[e]) {//target <= nums[e]
          s = mid +1;
        } else{
          e= mid-1;
        }
      }
    }
    return false;
  }

}
