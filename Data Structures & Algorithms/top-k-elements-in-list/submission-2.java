class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      Integer existingCount = frequencyMap.getOrDefault(num, 0) + 1;
      frequencyMap.put(num, existingCount);
    }

    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      buckets.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> frequencyMapEntry : frequencyMap.entrySet()) {
      int num = frequencyMapEntry.getKey();
      int freq = frequencyMapEntry.getValue();
      buckets.get(freq).add(num);
    }

    int[] result = new int[k];
    int resultIndex = 0;

    for (int i = buckets.size() - 1; i >= 0; i--) {
      for (int num : buckets.get(i)) {
        result[resultIndex] = num;
        resultIndex += 1;

        if (resultIndex == k) {
          return result;
        }
      }

    }

    return result;
  }
}
