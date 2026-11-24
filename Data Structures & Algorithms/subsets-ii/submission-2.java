class Solution {
  List<List<Integer>> subsets = new ArrayList<List<Integer>>();
  
  // DFS - Recursive, for-loop method with sorting
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    Arrays.sort(nums);
    this.dfsSorted(0, nums, currentSubset);
    return this.subsets;
  }
  
  private void dfsSorted(int index, int[] nums, List<Integer> subset) {
    this.subsets.add(new ArrayList<Integer>(subset));
    if (index >= nums.length) {
      return;
    }
    
    for (int i=index; i<nums.length; i++) {
      if (i>index && nums[i] == nums[i-1]) {
        continue;
      
      } else {
        subset.add(nums[i]);
        this.dfsSorted(i+1, nums, subset);
        subset.remove(subset.size()-1);
      }
    }
  }

}
