class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> depGraph = new HashMap<>();
        for(int i = 0; i < numCourses; i++) depGraph.put(i, new ArrayList<>());

        int[] blockingCount = new int[numCourses];

        for(var prerequisite: prerequisites) {
            depGraph.get(prerequisite[1]).add(prerequisite[0]);
            blockingCount[prerequisite[0]]++;
        }

        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(blockingCount[i] == 0) queue.offer(i);
        }

        int taken = 0;
        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            res[taken] = course;
            taken++;

            for(var dep: depGraph.get(course)) {
                if(--blockingCount[dep] == 0) queue.offer(dep);
            }
        }
        return taken == numCourses ? res : new int[0];
    }
}
