class Solution {
  public boolean isPalindrome(String s) {
    char[] sCharArray = s.toCharArray();
    int leftIndex = 0, rightIndex = sCharArray.length-1;
    
    while (leftIndex < rightIndex) {
      char left = sCharArray[leftIndex];
      char right = sCharArray[rightIndex];
      
      if (!Character.isLetterOrDigit(left)) {
        leftIndex += 1;
        continue;
      }
      
      if (!Character.isLetterOrDigit(right)) {
        rightIndex -= 1;
        continue;
      }
      
      if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
        return false;
      } else {
        leftIndex += 1;
        rightIndex -= 1;
      }
    }
    
    return true;
  }
}
