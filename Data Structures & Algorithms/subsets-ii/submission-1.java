class Solution {
  List<List<Integer>> subsets = new ArrayList<List<Integer>>();  
  
  // DFS - Recursive, for-loop method with hashmap 
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      int numFreq = freqMap.getOrDefault(num,0);
      freqMap.put(num,  numFreq+1);
    }
    List<Integer> uniqNums = new ArrayList<Integer>(freqMap.keySet());
    this.dfsRecursiveHashMap(0, uniqNums, currentSubset, freqMap);
    return this.subsets;
  }
  
  private void dfsRecursiveHashMap(int index, List<Integer> uniqNums, List<Integer> subset, Map<Integer, Integer> freqMap) {
    this.subsets.add(new ArrayList<Integer>(subset));
    
    if (index >= uniqNums.size()) {
      return;
    }
    
    for (int i=index; i<uniqNums.size(); i++) {
      int num = uniqNums.get(i);
      int numFreq = freqMap.get(num);
      if (numFreq>0) {
       subset.add(num);
       freqMap.put(num, numFreq-1);
       
       this.dfsRecursiveHashMap(i, uniqNums, subset, freqMap);
       
       subset.remove(subset.size()-1);
       freqMap.put(num, numFreq);
      }
    }
  }
}
