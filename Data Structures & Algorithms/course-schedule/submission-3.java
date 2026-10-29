class Solution {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseDep = new HashMap<>();
        for (var course : prerequisites) {
            courseDep.computeIfAbsent(course[0], v -> new ArrayList<>()).add(course[1]);
        }

        Set<Integer> onPath = new HashSet<>();
        for (var course : courseDep.keySet()) {
            if (hasCircle(course, courseDep, onPath)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCircle(Integer course, Map<Integer, List<Integer>> courseDep,
                              Set<Integer> onPath) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(course);

        while (!stack.isEmpty()) {
            Integer c = stack.peek();                 // peek: leave c on the stack
            List<Integer> deps = courseDep.get(c);

            if (onPath.contains(c)) {                 // second visit: deps all finished
                onPath.remove(c);
                deps.clear();                         // mark done
                stack.pop();
                continue;
            }

            if (deps == null || deps.isEmpty()) {     // no prerequisites, or already done
                stack.pop();
                continue;
            }

            onPath.add(c);                            // first visit: entering
            for (var dep : deps) {
                if (onPath.contains(dep)) return true;         // back edge -> cycle
                List<Integer> depDeps = courseDep.get(dep);
                if (depDeps != null && !depDeps.isEmpty()) stack.push(dep);
            }
        }
        return false;
    }
}
