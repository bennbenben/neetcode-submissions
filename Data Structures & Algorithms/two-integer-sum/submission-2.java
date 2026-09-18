class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    
    for (int i=0; i < nums.length; i++) {
      numsMap.put(nums[i], i);
    }
    
    for (int i=0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numsMap.containsKey(complement) && i != numsMap.get(complement)) {
        return new int[] {i, numsMap.get(complement)};
      }
    }
    return null;
  }
}
