class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            if (cur > 0) {
                st.push(cur);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && Math.abs(cur) > st.peek()) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(cur)) {
                    st.pop();
                    continue;  // current asteroid destroyed — skip pushing
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(cur);
                }
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
