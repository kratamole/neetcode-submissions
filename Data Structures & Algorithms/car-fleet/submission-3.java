class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> startPosSpeed = new HashMap<>();
        for (int i = 0; i < speed.length; i++) {
            startPosSpeed.put(position[i], Math.min(startPosSpeed.getOrDefault(position[i], Integer.MAX_VALUE), speed[i]));
        }
        // Stack<Double> fleetETAs = new Stack<>();
        Double fleetAheadETA = -1.0;
        int res = 0;
        for (int pos : startPosSpeed.keySet().stream().sorted(Comparator.reverseOrder()).toList()) {
            double eta = (double) (target - pos) / startPosSpeed.get(pos);
            // Car is the first to arrive (closest pos, empty stack)
            // OR
            // Car arrives later than the fleet ahead
            if (eta > fleetAheadETA) {
                fleetAheadETA = eta;
                res++; // form a new fleet
            }
        }
        return res;
    }
}
