class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length-1;
    int sum = numbers[i] + numbers[j];

    System.out.println("input numbers[]=" + Arrays.toString(numbers) + ", target=" + target);

    while (sum != target) {
      System.out.println("i=" + i + ", j=" + j + ", sum=" + sum);
      if (sum < target) {
        i += 1;
      } else if (sum > target) {
        j -= 1;
      }
      sum = numbers[i] + numbers[j];
    }
    
    System.out.println("Found a match. i=" + numbers[i] + ", while j=" + numbers[j]);
    System.out.println("Output 1-indexed array=" + Arrays.toString(new int[] { i + 1, j + 1 }));
    return new int[] { i + 1, j + 1 };
  }
}
