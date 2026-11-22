class Solution {
  // DFS - Recursive, for-loop method with hashmap 
  private List<List<Integer>> combinationSum2Result = new ArrayList<List<Integer>>();
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    this.combinationSum2Result.clear();
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for (int candidate : candidates) {
      int candidateFreq = freqMap.getOrDefault(candidate, 0)+1;
      freqMap.put(candidate, candidateFreq);
    }
    List<Integer> currentSubset = new ArrayList<Integer>();
    List<Integer> uniqCandidates = new ArrayList<Integer>(freqMap.keySet());
    this.dfsRecursiveHashMap(0, uniqCandidates, target, currentSubset, freqMap);
    return this.combinationSum2Result;
  }
  
  private void dfsRecursiveHashMap(int index, List<Integer> candidates, int target, List<Integer> subset, Map<Integer, Integer> freqMap) {
    if (target == 0) {
      this.combinationSum2Result.add(new ArrayList<Integer>(subset));
      return;
    }
    
    if (target<0 || index >= candidates.size()) {
      return;
    }
    
    for (int i=index; i<candidates.size(); i++) {
      int candidate = candidates.get(i);
      int candidateCount = freqMap.get(candidate);  
      
      if (candidateCount > 0) {  
        subset.add(candidate);
        candidateCount -= 1;
        freqMap.put(candidate, candidateCount);
        this.dfsRecursiveHashMap(i, candidates, target-candidate, subset, freqMap);
        
        subset.remove(subset.size()-1);
        candidateCount += 1;
        freqMap.put(candidate, candidateCount);
      }
    }
  }
}
