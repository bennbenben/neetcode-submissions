class Solution {
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length-1;    
    
    while (left < right) {
      
      int sum = numbers[left] + numbers[right];
      if (sum < target) {
        left += 1;
        continue;
      } else if (sum > target) {
        right -= 1;
        continue;
      } else {
        return new int[] {left+1, right+1};
      }
    }
    return null;
  }
}
