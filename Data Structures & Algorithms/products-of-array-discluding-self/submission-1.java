class Solution {
    public int[] productExceptSelf(int[] nums) {
    int[] leftArray = new int[nums.length];
    leftArray[0] = 1;
    for (int i=1; i<nums.length; i++) {
      leftArray[i] = nums[i-1] * leftArray[i-1];
    }
    System.out.println(Arrays.toString(leftArray));
    
    int rightInt = 1;
    int j;
    for (int i=0; i<nums.length; i++) {
      j = nums.length-1-i; // 4-1-1=2
      leftArray[j] = leftArray[j] * rightInt; // leftArray[2] = 2*6 
      rightInt = rightInt*nums[j]; // rightInt = 6
    }
    
    System.out.println(Arrays.toString(leftArray));
    
    return leftArray;
  }

}  
