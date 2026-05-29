class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (String operation : operations) {
            try {
                stack.push(Integer.parseInt(operation));
            } catch (NumberFormatException e) {
                switch (operation) {
                    case "+": {
                        if (stack.size() < 2) {
                            break;
                        }

                        int firstValue = stack.pop();
                        int secondValue = stack.peek();
                        stack.push(firstValue);
                        stack.push(firstValue+secondValue);
                        break;
                    }
                    case "C": {
                        if (!stack.empty()) {
                            stack.pop();
                        }
                        break;
                    }
                    case "D": {
                        int firstValue = stack.peek();
                        stack.push(firstValue*2);
                        break;
                    }
                }
            }
            
        }

        while (!stack.empty()) {
            int value = stack.pop();
            result += value;
        }

        return result;
    }
}