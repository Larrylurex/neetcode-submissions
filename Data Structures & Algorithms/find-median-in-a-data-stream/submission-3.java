class MedianFinder {

    Queue<Integer> lowHalf;
    Queue<Integer> topHalf;
    public MedianFinder() {
        lowHalf = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        topHalf = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
    }

    public void addNum(int num) {
        lowHalf.add(num);

        if(lowHalf.size()  - topHalf.size() > 1 ||
                (!topHalf.isEmpty() && lowHalf.peek() > topHalf.peek())) {
            topHalf.add(lowHalf.poll());
        }
        if (topHalf.size() - lowHalf.size() > 1) {
            lowHalf.add(topHalf.poll());
        }
    }

    // 1 2 3 4 5 6
     public double findMedian() {
        if(lowHalf.isEmpty()) return 0.0;
        if(lowHalf.size() == topHalf.size()) {
            return (double)(lowHalf.peek() + topHalf.peek())/2;
        } else if(lowHalf.size() > topHalf.size()) {
            return lowHalf.peek();
        } else {
            return topHalf.peek();
        }
    }
}
