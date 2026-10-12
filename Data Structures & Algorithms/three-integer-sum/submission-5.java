class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> threeSumResultList = new ArrayList<List<Integer>>();
    
    for (int i=0; i<nums.length-2;i++) {
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }
      
      int left = i+1, right = nums.length-1;
      while (left < right) {
        int threeSum = nums[i] + nums[left] + nums[right];
        if (threeSum < 0) {
          left += 1;
          continue;
        } else if (threeSum > 0) {
          right -= 1;
          continue;
        } else {
          threeSumResultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left += 1;
          right -= 1;
          
          while (left < right && nums[left] == nums[left-1]) {
            left += 1;
          }
        }
      }
    }
    return threeSumResultList;
  }
}
