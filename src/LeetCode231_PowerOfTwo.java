public class LeetCode231_PowerOfTwo {
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        return n % 2 == 0 ? isPowerOfTwo2(n / 2) : false;
    }
    // n&(n-1) trick
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n&(n-1)) == 0;
    }
}
