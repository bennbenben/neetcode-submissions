class Solution {
  public int evalRPN(String[] tokens) {
    LinkedList<Integer> rpnStack = new LinkedList<Integer>();
    
    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          Integer a = rpnStack.poll();  
          Integer b = rpnStack.poll();  
          rpnStack.offerFirst(b+a);
        }
        case "-" -> {
          Integer a = rpnStack.poll();  
          Integer b = rpnStack.poll();  
          rpnStack.offerFirst(b-a);        
        }
        case "*" -> {
          Integer a = rpnStack.poll();  
          Integer b = rpnStack.poll();  
          rpnStack.offerFirst(b*a);          
        }
        case "/" -> {
          Integer a = rpnStack.poll();  
          Integer b = rpnStack.poll();  
          rpnStack.offerFirst(b/a);  
        }
        default -> {
          rpnStack.offerFirst(Integer.valueOf(token));
        }
      }
    }
    return rpnStack.pollFirst();
  }
}
