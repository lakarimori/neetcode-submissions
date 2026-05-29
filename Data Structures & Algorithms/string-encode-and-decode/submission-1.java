class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            encodedString.append(str.length() + "#" + str);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        for (int i=0; i<str.length(); i++) {
            int size = 0;
            while (str.charAt(i) != '#') {
                size *= 10;
                size += str.charAt(i) - '0';
                i++;
            }

            StringBuilder currentString = new StringBuilder();
            while (size > 0) {
                i++;
                currentString.append(str.charAt(i));
                size--;
            }
            decoded.add(currentString.toString());
            
        }

        return decoded;
    }
}
