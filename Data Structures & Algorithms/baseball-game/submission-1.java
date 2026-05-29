class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (String operation : operations) {
            switch (operation) {
                case "+": {
                    if (stack.size() < 2) {
                        break;
                    }

                    int firstValue = stack.pop();
                    int secondValue = stack.peek();
                    stack.push(firstValue);
                    stack.push(firstValue+secondValue);
                    result += firstValue+secondValue;
                    break;
                }
                case "C": {
                    if (!stack.empty()) {
                        int value = stack.pop();
                        result -= value;
                    }
                    break;
                }
                case "D": {
                    int firstValue = stack.peek();
                    stack.push(firstValue*2);
                    result += firstValue*2;
                    break;
                }
                default: {
                    int value = Integer.parseInt(operation); 
                    stack.push(value);
                    result += value;
                    break;
                }
            }
        }

        return result;
    }
}