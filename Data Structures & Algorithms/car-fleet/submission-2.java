class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
    int[][] startingPositionsIndex = new int[position.length][2];
    for (int i=0; i<position.length; i++) {
      startingPositionsIndex[i][0] = position[i];
      startingPositionsIndex[i][1] = i;
    }
    // System.out.printf("startingPositionsIndex=%s%n", Arrays.deepToString(startingPositionsIndex));
    Arrays.sort(startingPositionsIndex, Comparator.comparingInt(item -> item[0]));
    // System.out.printf("startingPositionsIndex=%s%n", Arrays.deepToString(startingPositionsIndex));

    LinkedList<int[]> carFleetStack = new LinkedList<int[]>();
    for (int i=position.length-1;i>=0;i--) {
      if (carFleetStack.isEmpty()) {
        carFleetStack.offerFirst(startingPositionsIndex[i]);
      } else {
        
        int[] headCarStats = carFleetStack.peekFirst();
        double headCarDuration = (double) (target - headCarStats[0]) / speed[headCarStats[1]];
        
        int[] incomingCarStats = startingPositionsIndex[i];
        double incomingCarDuration = (double) (target - incomingCarStats[0]) / speed[incomingCarStats[1]];
        
        if (incomingCarDuration <= headCarDuration) {
          continue;
        } else {
          carFleetStack.offerFirst(incomingCarStats);
        }
        
      }
    }
    
    // System.out.printf("carFleetStack=%s%n", Arrays.deepToString(carFleetStack.toArray()));
    return carFleetStack.size();
  }
}
