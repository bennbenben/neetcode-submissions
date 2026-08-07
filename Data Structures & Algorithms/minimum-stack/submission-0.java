public class MinStack {
  
  private final LinkedList<Integer> stack = new LinkedList<Integer>();
  private final LinkedList<Integer> periodicMinStack = new LinkedList<Integer>();

  public MinStack() {
    
  }
  
  public void push(int val) {
    stack.offerFirst(val);
    if (periodicMinStack.isEmpty()) {
      this.periodicMinStack.offerFirst(val);
    } else {
      this.periodicMinStack.offerFirst(Math.min(val, periodicMinStack.peekFirst()));
    }
  }


  public void pop() {
    this.periodicMinStack.pollFirst();
    this.stack.pollFirst();
  }

  public int top() {
    return this.stack.peekFirst();
  }

  public int getMin() {
    return this.periodicMinStack.peekFirst();
  }
}
