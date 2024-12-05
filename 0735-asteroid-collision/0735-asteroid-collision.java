class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int x : asteroids) {
            boolean exploded = false;
            while (!stack.isEmpty() && x < 0 && stack.peek() > 0) {
                if (Math.abs(x) > Math.abs(stack.peek())) {
                    stack.pop(); // Current asteroid destroys the top of the stack
                } else if (Math.abs(x) == Math.abs(stack.peek())) {
                    stack.pop(); // Both asteroids destroy each other
                    exploded = true; // Mark the current asteroid as exploded
                    break;
                } else {
                    exploded = true; // Current asteroid is destroyed
                    break;
                }
            }
            if (!exploded) {
                stack.push(x); // Push the current asteroid if it survives
            }
        }

        // Convert stack to array for result
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}