class Solution {
  public boolean isValid(String s) {
    Map<Character, Character> complementParenthesisMap = new HashMap<Character, Character>();
    complementParenthesisMap.put('(', ')');
    complementParenthesisMap.put('{', '}');
    complementParenthesisMap.put('[', ']');
    
    LinkedList<Character> parenthesisStack = new LinkedList<Character>();
    for (Character sChar : s.toCharArray()) {
      if (complementParenthesisMap.containsKey(sChar)) {
        parenthesisStack.offer(sChar);
      } else {
        if (parenthesisStack.isEmpty()) {
          return false;
        }
        Character tailChar = parenthesisStack.pollLast();
        Character tailComplementChar = complementParenthesisMap.get(tailChar);
        if (!tailComplementChar.equals(sChar)) {
          return false;
        }
      }
    }
    
    if (parenthesisStack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
