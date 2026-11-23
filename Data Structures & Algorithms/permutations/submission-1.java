class Solution {
  private List<List<Integer>> permutations = new ArrayList<List<Integer>>();

  // DFS - Recursive 
  public List<List<Integer>> permute(int[] nums) {
    this.permutations.clear();
    
    List<Integer> currentSubset = new ArrayList<Integer>();
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      int numFreq = freqMap.getOrDefault(num, 0);
      freqMap.put(num, numFreq+1);
    }
    
    this.dfsRecursive(nums, currentSubset, freqMap);
    return this.permutations;
  }
  
  private void dfsRecursive(int[] nums, List<Integer> subset, Map<Integer, Integer> freqMap) {
    if (subset.size() == nums.length) {
      this.permutations.add(new ArrayList<Integer>(subset));
      return;
    }
    
    for (int i=0; i<nums.length; i++) {
      int num = nums[i];
      int numFreq = freqMap.get(num);
      if (numFreq>0) {
        subset.add(num);
        freqMap.put(num, numFreq-1);
        
        this.dfsRecursive(nums, subset, freqMap);
        
        subset.remove(subset.size()-1);
        freqMap.put(num, numFreq);
      }
    }
  }
}
