class Solution {
  // DFS - Recursive, for-loop method with sorting
  private List<List<Integer>> combinationSum2Result = new ArrayList<List<Integer>>();
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    this.combinationSum2Result.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    Arrays.sort(candidates);
    this.dfsRecursiveForLoop(0, candidates, target, currentSubset);
    return this.combinationSum2Result;
  }
  
  private void dfsRecursiveForLoop(int index, int[] candidates, int target, List<Integer> subset) {
    if (target == 0) {
      this.combinationSum2Result.add(new ArrayList<Integer>(subset));
      return;
    }
    
    if (target<0 || index >= candidates.length) {
      return;
    }
    
    for (int i=index; i<candidates.length; i++) {
      if (i>index && candidates[i] == candidates[i-1]) {
        continue;
      }
      
      int candidate = candidates[i];
      subset.add(candidate);
      this.dfsRecursiveForLoop(i+1, candidates, target-candidate, subset); // i+1 because no duplicates
      subset.remove(subset.size()-1);
    }
  }
}
