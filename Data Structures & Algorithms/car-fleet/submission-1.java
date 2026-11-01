class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> startPosSpeed = new HashMap<>();
        for (int i = 0; i < speed.length; i++) {
            startPosSpeed.put(position[i], Math.min(startPosSpeed.getOrDefault(position[i], Integer.MAX_VALUE), speed[i]));
        }
        Stack<Double> fleetETAs = new Stack<>();
        for (int pos : startPosSpeed.keySet().stream().sorted(Comparator.reverseOrder()).toList()) {
            double eta = (double) (target - pos) / startPosSpeed.get(pos);
            if (fleetETAs.size() == 0 || eta > fleetETAs.peek()) {
                fleetETAs.push(eta);
            }
        }
        return fleetETAs.size();
    }
}
