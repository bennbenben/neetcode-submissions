class Solution {
  public boolean isPalindrome(String s) {
    char[] sCharArray = s.toCharArray();
    int i=0, j=sCharArray.length-1;
    
    while (i<j) {
      
      char left = sCharArray[i];
      char right = sCharArray[j];
      
      System.out.println("Testing for left_char=" + left + " and right_char=" + right);
      
      if (!Character.isLetterOrDigit(left)) {
        System.out.println("left_char=" + left + "is invalid character, incrementing pointer i=" + i);
        i += 1;
        continue;
      } 
      
      if (!Character.isLetterOrDigit(right)) {
        System.out.println("right_char=" + right + "is invalid character, decrementing pointer j=" + j);
        j -= 1;
        continue;
      }
      left = Character.toLowerCase(left);
      right = Character.toLowerCase(right);
      
      if (left != right) {
        return false;
      }
      
      i += 1;
      j -= 1;
    }
    
    return true;
  }
}
