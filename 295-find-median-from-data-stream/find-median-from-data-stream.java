class MedianFinder {
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        maxpq = new PriorityQueue<>((a,b)->Integer.compare(b,a));  
    }
    
    public void addNum(int num) {
        if(maxpq.isEmpty() || num< maxpq.peek() ){
            maxpq.offer(num);
        }else{
            minpq.offer(num);
        }
        if(minpq.size()>maxpq.size()){
            maxpq.offer(minpq.poll());
        }else if(maxpq.size()-minpq.size()>1){
            minpq.offer(maxpq.poll());
        }
    }
    
    public double findMedian() {
        if (maxpq.size() > minpq.size()) {
            return maxpq.peek();
        }
        return (maxpq.peek() + minpq.peek()) / 2.0;
    } 
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */