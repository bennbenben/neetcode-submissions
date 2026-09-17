class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicatesSet = new HashSet();
        for (int num : nums) {
            if (duplicatesSet.contains(num)) {
                return true;
            } else {
                duplicatesSet.add(num);
            }
            
        }
        return false;
    }
}