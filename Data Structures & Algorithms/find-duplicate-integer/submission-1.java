class Solution {
  public int findDuplicate(int[] nums) { // nums = [1,2,3,2,2]
    int low = 1; int high = nums.length-1; 
    int mid; int count;
    while (low < high) {
      mid = (low + high)/2;
      count = 0;
      for (int num:nums) {
        if (num <= mid) {
          count+=1;
        }
      }
      if (count > mid) {
        high = mid; // keep low as-is, because duplicated value is between 1 to mid (inclusive)
      } else {
        low = mid+1; // keep high as-is, because 1 to mid (inclusive) is fine
      }
    }
    return low;
  }
}
