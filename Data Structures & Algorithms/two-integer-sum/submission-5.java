class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> complementMap = new HashMap<Integer, Integer>();
    
    for (int i=0; i<nums.length; i++) {
      int diff = target - nums[i];
      if (complementMap.containsKey(diff)) {
        return new int[] {complementMap.get(diff), i};
      } else {
        complementMap.put(nums[i], i);
      }
    }
    return null;
  }
}
