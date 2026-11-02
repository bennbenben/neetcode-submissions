class Solution {
  public int findDuplicate(int[] nums) { // nums = [1,2,3,2,2]
    int slowNumIdx = 0; int fastNumIdx = 0;
    do {
      slowNumIdx = nums[slowNumIdx];
      fastNumIdx = nums[nums[fastNumIdx]];
    }
    while (slowNumIdx != fastNumIdx);
    
    slowNumIdx=0;
    while (slowNumIdx != fastNumIdx) {
      slowNumIdx = nums[slowNumIdx];
      fastNumIdx = nums[fastNumIdx];
    }
    return slowNumIdx;
  }

}
