class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      Integer existingCount = frequencyMap.get(num);
      if (existingCount == null) {
        frequencyMap.put(num, 1);
      } else {
        existingCount += 1;
        frequencyMap.put(num, existingCount);
      }
    }

    int[][] frequencyArray = new int[frequencyMap.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> frequencyMapEntry : frequencyMap.entrySet()) {
      frequencyArray[i][0] = frequencyMapEntry.getKey();
      frequencyArray[i][1] = frequencyMapEntry.getValue();
      i += 1;
    }

    Arrays.sort(frequencyArray, Comparator.comparingInt(item -> item[1]));
    i = 0;
    int[] result = new int[k];
    while (i < k) {
      result[i] = frequencyArray[frequencyMap.size() - 1 - i][0];
      i += 1;
    }
    return result;
  }
}
