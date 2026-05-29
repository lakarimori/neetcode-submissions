class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else {
                if (chars.empty()) {
                    return false;
                }
                
                char lastChar = chars.pop();
                switch (c) {
                    case ')': {
                        if (lastChar != '(') {
                            return false;
                        }
                        break;
                    }
                    case '}': {
                        if (lastChar != '{') {
                            return false;
                        }
                        break;
                    }
                    case ']': {
                        if (lastChar != '[') {
                            return false;
                        }
                        break;
                    }
                }
            }
        }

        return chars.empty();
    }
}
