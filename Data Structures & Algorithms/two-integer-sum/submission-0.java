class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    
    for (int i=0; i<nums.length; i++) {
      numsMap.put(nums[i], i);
    }
    
    int diff;
    for (int i=0; i<nums.length; i++) {
      diff = target - nums[i];
      if (numsMap.containsKey(diff) && numsMap.get(diff) != i) {
        return new int[] {i, numsMap.get(diff)};
      }
    }
    
    return null;
  }

}
