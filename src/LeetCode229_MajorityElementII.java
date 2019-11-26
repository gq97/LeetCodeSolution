import java.util.LinkedList;
import java.util.List;

public class LeetCode229_MajorityElementII {
    // Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int count1 = 0, count2 = 0, candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            } else if(count1 == 0) {
                count1 = 1;
                candidate1 = num;
            } else if(count2 == 0) {
                count2 = 1;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            }
        }
        if(count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if(count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
