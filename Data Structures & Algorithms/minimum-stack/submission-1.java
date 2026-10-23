class MinStack {
  private LinkedList<Integer> mainStack;
  private LinkedList<Integer> minStack; 

  public MinStack() {
    this.mainStack = new LinkedList<Integer>();
    this.minStack = new LinkedList<Integer>();
  }
  
  public void push(int val) {
    this.mainStack.offerLast(val);
    
    if (this.minStack.isEmpty()) {
      this.minStack.offerLast(val);
    } else {
      int smallerVal = Math.min(val, this.minStack.peekLast());
      this.minStack.offerLast(smallerVal);
    }
  }
  
  public void pop() {
    this.mainStack.pollLast();
    this.minStack.pollLast();
  }
  
  public int top() {
    return this.mainStack.peekLast();
  }
  
  public int getMin() {
    return this.minStack.peekLast();
  }
}
