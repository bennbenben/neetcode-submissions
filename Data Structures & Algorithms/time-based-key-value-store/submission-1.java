class TimeMap {
  public class TimeNode {
    private String value;
    private int timestamp;
    
    public TimeNode(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }
  }
  
  Map<String, List<TimeNode>> timeBasedKeyValueMap = new HashMap<String, List<TimeNode>>();
  
  public TimeMap() {
    
  }
  
  public void set(String key, String value, int timestamp) {
    if (!this.timeBasedKeyValueMap.containsKey(key)) {
      this.timeBasedKeyValueMap.put(key, new ArrayList<TimeMap.TimeNode>());
    }
    List<TimeNode> node = this.timeBasedKeyValueMap.get(key);
    node.add(new TimeNode(value, timestamp));
  }
  
  public String get(String key, int timestamp) {
    if (!this.timeBasedKeyValueMap.containsKey(key)) {
      return "";
    }
    
    List<TimeNode> nodeList = this.timeBasedKeyValueMap.get(key);
    int left=0; int right=nodeList.size()-1;
    while (left<=right) {
      int mid = left+(right-left)/2;
      if (nodeList.get(mid).timestamp == timestamp) {
        return nodeList.get(mid).value;
      }
      
      if (timestamp < nodeList.get(mid).timestamp) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    
    if (right >= 0) {
      return nodeList.get(right).value;
    } else {
      return "";
    }
  }
}
