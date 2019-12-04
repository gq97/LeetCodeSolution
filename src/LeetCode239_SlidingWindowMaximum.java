import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len < k || k < 1) return new int[0];
        int[] result = new int[len-k+1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            while(!deque.isEmpty() && i - deque.peek() >= k) {
                deque.pop();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if(i >= k-1) {
                result[idx++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
