class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) { 
      int existingCount = frequencyMap.getOrDefault(num, 0);
      frequencyMap.put(num, existingCount+1);
    }
    
    int[][] frequencyArray = new int [frequencyMap.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      frequencyArray[i][0] = entry.getKey();
      frequencyArray[i][1] = entry.getValue();
      i += 1;
    }
    Arrays.sort(frequencyArray, (a, b) -> b[1] - a[1]);
    
    int[] frequentElements = new int[k];
    for (i = 0; i < k; i++) {
      frequentElements[i] = frequencyArray[i][0];
    }
    return frequentElements;
  }

}
