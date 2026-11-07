class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
    int left = 0; int right = matrix.length * matrix[0].length -1;
    
    while (left <= right) {
      int mid = left + (right-left)/2;
      int midRow = mid/matrix[0].length; int midCol = mid%matrix[0].length;
      if (matrix[midRow][midCol] == target) {
        return true;
      }
      if (matrix[midRow][midCol] < target) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return false;
  }
}
