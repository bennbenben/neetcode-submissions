class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) { 
      int existingCount = frequencyMap.getOrDefault(num, 0);
      frequencyMap.put(num, existingCount+1);
    }
    
    List<List<Integer>> elementBuckets = new ArrayList<List<Integer>>();
    for (int i=0; i<=nums.length; i++) {
      elementBuckets.add(new ArrayList<Integer>());
    }
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      elementBuckets.get(entry.getValue()).add(entry.getKey());
    }
    
    int[] frequentElements = new int[k];
    int resultIndex = 0;
    for (int i = elementBuckets.size() - 1; i >= 0 ; i--) {
      List<Integer> elementArray = elementBuckets.get(i);
      for (int element : elementArray) {
        frequentElements[resultIndex] = element;
        resultIndex += 1;
        if (resultIndex == k) {
          return frequentElements;
        }
      }
    }
    
    return null;
  }
}
