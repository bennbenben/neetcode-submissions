class Solution {
  public boolean isValid(String s) {
    System.out.printf("input String s=%s%n",s);
    Map<Character, Character> complementParenthesis = new HashMap<Character, Character>();
    complementParenthesis.put('(',')');
    complementParenthesis.put('{','}');
    complementParenthesis.put('[',']');
    System.out.printf("complementParenthesis=%s%n", complementParenthesis.toString());
    
    LinkedList<Character> parenthesisStack = new LinkedList<Character>();
    for (char sChar : s.toCharArray()) {
      System.out.printf("Existing sChar=%s, parenthesisStack=%s%n", sChar, parenthesisStack.toString());
      if (complementParenthesis.containsKey(sChar)) {
        parenthesisStack.offerFirst(sChar);
      } else {
        if (parenthesisStack.isEmpty() || !complementParenthesis.get(parenthesisStack.pollFirst()).equals(sChar)) {
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
