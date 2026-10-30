class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDep = new HashMap<>();
        int[] depCount = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            courseDep.put(i, new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            courseDep.get(course[1]).add(course[0]);
            depCount[course[0]]++;
        }

        Queue<Integer> courses = new LinkedList<>();
        int taken = 0;
        for(int i = 0 ; i < depCount.length; i++) {
            if(depCount[i] == 0) {
                courses.offer(i);
            }
        }

        while(!courses.isEmpty()) {
            Integer course = courses.poll();
            taken++;
            for(var dep: courseDep.get(course)) {
                if(--depCount[dep] == 0) courses.offer(dep);
            }

        }

        return taken == numCourses;
    }
}
