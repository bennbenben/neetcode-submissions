class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int complement, left, right;
    
    for (int i=0; i<numbers.length; i++) {
      complement = target - numbers[i];
      left = i+1;
      right = numbers.length-1;
      
      while (left <= right) {
        int mid = (right - left)/2 + left;
        
        if (numbers[mid] == complement) {
          return new int[] {i+1, mid+1};
        
        } else if (numbers[mid] < complement) {
          left = mid + 1;
        
        } else {
          right = mid - 1;
        }
      }
      
    }
    
    return null;
  }

}
