public class LeetCode223_RectangleArea {
    // learn from the discussion
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = (C - A) * (D - B) + (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        if(right > left && top > bottom) {
            result -= (right - left) * (top - bottom);
        }
        return result;
    }
}
