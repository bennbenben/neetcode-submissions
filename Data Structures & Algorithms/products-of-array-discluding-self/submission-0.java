class Solution {
    public int[] productExceptSelf(int[] nums) {
    int[] leftArray = new int[nums.length];
    leftArray[0] = 1;
    for (int i=1; i<nums.length; i++) {
      leftArray[i] = nums[i-1] * leftArray[i-1];
    }
    
    System.out.println(Arrays.toString(leftArray));
    
    int[] rightArray = new int[nums.length];
    rightArray[nums.length-1] = 1;
    for (int i=nums.length-2; i>-1; i--) {
      rightArray[i] = nums[i+1] * rightArray[i+1];
    }
    
    System.out.println(Arrays.toString(rightArray));
    
    int[] resultArray = new int[nums.length];
    for (int i=0; i<resultArray.length;i++) {
      resultArray[i]=leftArray[i]*rightArray[i];
    }
    
    return resultArray;
  }
}  
