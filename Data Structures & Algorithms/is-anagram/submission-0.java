class Solution {
    public boolean isAnagram(String s, String t) {
    char[] sCharArr = s.toCharArray();
    Arrays.sort(sCharArr);
    
    char[] tCharArr = t.toCharArray();
    Arrays.sort(tCharArr);
    
    return Arrays.equals(sCharArr, tCharArr);
    }
}
