class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
    int[][] positionAndSpeed = new int[position.length][2];
    for (int i=0; i<position.length; i++) {
      positionAndSpeed[i][0] = position[i]; 
      positionAndSpeed[i][1] = speed[i];
    }
    Arrays.sort(positionAndSpeed, (a,b) -> {
      return a[0] - b[0];
    });
//    System.out.printf("positionAndSpeed=%s%n", Arrays.deepToString(positionAndSpeed));
        
    LinkedList<Double> carFleetStack = new LinkedList<Double>();
    for (int i=positionAndSpeed.length-1; i>=0; i--) {
      double completionDuration = (target - positionAndSpeed[i][0]) / (double) positionAndSpeed[i][1];
      if (!carFleetStack.isEmpty()) {
        double currentLeaderCompletionDuration = carFleetStack.peekFirst();
        if (completionDuration > currentLeaderCompletionDuration) {
          carFleetStack.offerFirst(completionDuration);
        }
      } else {
        carFleetStack.offerFirst(completionDuration);
      }
    }

    return carFleetStack.size();
  }
}
