class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int i,j,k;
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    for (i=0; i<nums.length-2; i++) {
      if (i > 0 && (nums[i-1] == nums[i])) {
//        System.out.println("Skipping outer duplicate for value: " + nums[i]);
        continue;
      }
      
      j = i+1;
      k = nums.length-1;
      
      while (j<k) {
        int threeSum = nums[i] + nums[j] + nums[k];
//        System.out.println(String.format("Evaluating pointers: i=%d, j=%d, k=%d | Sum: %d + %d + %d = %d", 
//            i, j, k, nums[i], nums[j], nums[k], threeSum));
        
        if (threeSum < 0) {
          j+=1;
        } else if (threeSum > 0) {
          k -= 1;
        } else {
//          System.out.println("Match found, adding to result");
          result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
          j += 1;
          k -= 1;
          
          while (j < k && (nums[j] == nums[j-1])) {
            j+=1;
          }
          
        }
      }
      
    }
    return result;
  }
}
