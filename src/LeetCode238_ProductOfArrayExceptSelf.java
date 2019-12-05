public class LeetCode238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int leftMultiply = 1;
        for(int i = 0; i < len; i++) {
            result[i] = leftMultiply;
            leftMultiply *= nums[i];
        }
        int rightMultiply = 1;
        for(int i = len-1; i >= 0; i--) {
            result[i] *= rightMultiply;
            rightMultiply *= nums[i];
        }
        return result;
    }
}
