import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> lo_heap;
    PriorityQueue<Integer> hi_heap;

    /** initialize your data structure here. */
    public MedianFinder() {
        hi_heap = new PriorityQueue<>();
        lo_heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // generate max heap
            }
        });
    }

    public void addNum(int num) {
        lo_heap.add(num);
        hi_heap.add(lo_heap.poll());
        if(lo_heap.size() < hi_heap.size()) {
            lo_heap.add(hi_heap.poll());
        }
    }

    public double findMedian() {
        if((lo_heap.size() + hi_heap.size()) % 2 == 0) {
            return (lo_heap.peek() + hi_heap.peek()) / 2.0;
        }
        return lo_heap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class LeetCode295_FindMedianfromDataStream {
    public static void main(String[] args) {

    }
}