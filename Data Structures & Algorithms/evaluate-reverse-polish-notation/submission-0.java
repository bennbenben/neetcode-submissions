class Solution {
  public int evalRPN(String[] tokens) {
    LinkedList<Integer> integerStack = new LinkedList<Integer>();
    
    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second + first);
        }
        case "-" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second - first);
        }
        case "*" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second * first);
        }
        case "/" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second / first);
        }
        default -> {
          integerStack.offerFirst(Integer.parseInt(token));
        }
      }
    }
    return integerStack.pollFirst();
  }
}
