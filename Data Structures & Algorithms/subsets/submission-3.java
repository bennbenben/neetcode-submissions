class Solution {
  List<List<Integer>> subsets = new ArrayList<List<Integer>>();
  
  // DFS - Recursive 
  public List<List<Integer>> subsets(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    this.dfsRecursive(0, nums, currentSubset);
    return this.subsets;
  }
  
  private void dfsRecursive(int index, int[] nums, List<Integer> subset) {
    if (index == nums.length) {
      this.subsets.add(new ArrayList<Integer>(subset));
      return;
    }
    
    // branch left: save current number
    int num = nums[index];
    subset.add(num);
    this.dfsRecursive(index+1, nums, subset);

    // branch right: skip current number
    subset.remove(subset.size()-1);
    this.dfsRecursive(index+1, nums, subset);
  }

}
