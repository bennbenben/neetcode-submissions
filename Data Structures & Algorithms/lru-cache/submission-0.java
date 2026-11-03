class LRUCache {
  private HashMap<Integer, Node> lruHashMap = new HashMap<Integer, LRUCache.Node>();
  private Node head = new Node(-1, -1); 
  private Node tail = new Node(-1, -1);
  private int capacity;
  
  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }
  
  public int get(int key) {
    
    if (!this.lruHashMap.containsKey(key)) {
      return -1;
    } 
    
    Node lruNode = this.lruHashMap.get(key); // <advance here, .prev> head A <-> B <-> C tail <advance here, .next>
    
    // get the left and right side nodes
    Node prevLruNode = lruNode.prev; Node nextLruNode = lruNode.next;
    prevLruNode.next = nextLruNode;
    nextLruNode.prev = prevLruNode;
    
    // append at the tail and update pointers
    Node lastRealNode = tail.prev;
    lastRealNode.next = lruNode;
    lruNode.prev = lastRealNode;
    
    lruNode.next = this.tail;
    this.tail.prev = lruNode;
    
    return lruNode.val;
  }
  
  public void put(int key, int value) {
    
    if (this.lruHashMap.containsKey(key)) {
      // remove node
      // add node at the back
      Node lruNode = this.lruHashMap.get(key);
      lruNode.val = value;
      
      // get left and right nodes
      Node prevLruNode = lruNode.prev; Node nextLruNode = lruNode.next;
      prevLruNode.next = nextLruNode;
      nextLruNode.prev = prevLruNode;
      
      // append at the tail and update pointers
      Node lastRealNode = tail.prev;
      lastRealNode.next = lruNode;
      lruNode.prev = lastRealNode;
      
      lruNode.next = this.tail;
      this.tail.prev = lruNode;
      
    } else {
      // check capacity, evict head if required
      // add node at the back 
      if (this.lruHashMap.size() == this.capacity) {
        Node firstRealNode = this.head.next;
        this.head.next = firstRealNode.next;
        firstRealNode.next.prev = this.head;
        
        this.lruHashMap.remove(firstRealNode.key);
      }
      
      Node incomingNode = new Node(key, value);
      Node lastRealNode = tail.prev;
      lastRealNode.next = incomingNode; incomingNode.prev = lastRealNode;
      incomingNode.next = this.tail; this.tail.prev = incomingNode;
      
      this.lruHashMap.put(key, incomingNode);
    }
  }
  
  private class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
      this.key=key;
      this.val=val;
    }
  }
}
