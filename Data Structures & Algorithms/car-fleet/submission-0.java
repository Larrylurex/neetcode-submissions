class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for(int i = cars.length - 1; i >= 0; i--){
            double time = (target - cars[i][0]) / (double)cars[i][1];
            if(stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
