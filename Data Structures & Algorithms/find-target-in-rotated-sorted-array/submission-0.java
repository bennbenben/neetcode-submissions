class Solution {
  public int search(int[] nums, int target) {
    int left=0; int right=nums.length-1;
    
    while (left <= right) {
      int mid = left + (right-left)/2;
      if (nums[mid] == target) {
        return mid;
      }
      
      if (nums[left] <= nums[mid]) { // left to mid (inclusive) is sorted
        if (nums[left] <= target && target < nums[mid]) { // target is between left (inclusive) to mid (exclusive)
          right = mid - 1;
        } else { // target is between mid (inclusive) to right (inclusive)
          left = mid + 1;
        }
        
      } else { // mid (exclusive) to right is sorted
        if (nums[mid] < target && target <= nums[right]) { // target is between mid (exclusive) and right (inclusive)
          left = mid + 1;
        } else { // target is between left (inclusive) to mid (exclusive)
          right = mid - 1;
        }
      }
    }
    
    return -1;
    
  }
}
