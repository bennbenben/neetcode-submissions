class Solution {
  List<List<Integer>> subsets = new ArrayList<List<Integer>>();
  // DFS - Recursive using For-loop
  public List<List<Integer>> subsets(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    this.dfsRecursiveForLoop(0, nums, currentSubset);
    return this.subsets;
  }
  
  private void dfsRecursiveForLoop(int index, int[] nums, List<Integer> subset) {
    this.subsets.add(new ArrayList<Integer>(subset));
    
    for (int i=index; i<nums.length; i++) {
      subset.add(nums[i]);
      this.dfsRecursiveForLoop(i+1, nums, subset);
      subset.remove(subset.size()-1);
    }
  }

}
