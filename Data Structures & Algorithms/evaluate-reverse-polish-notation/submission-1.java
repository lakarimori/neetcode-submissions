class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1+val2);
            } else if (token.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1*val2);
            } else if (token.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2-val1);
            } else if (token.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2/val1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
