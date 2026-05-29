class Solution {
    /*
    First: check if words fit in the maxWidth with spaces

    during a loop, add spaces from left until get the maxWidth

    - Lines with only 1 word are left justified (word on left + spaces)
    - Last lines are left justified
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0, i = 0;

        while (i < words.length) {
            // If the current word can fit in the line
            if (length + words[i].length() + line.size() <= maxWidth) {
                line.add(words[i]);
                length += words[i].length();
                i++;
            } else {
                // Line complete
                int extra_space = maxWidth - length;
                int remainder = extra_space % Math.max(1, (line.size() - 1));
                int space = extra_space / Math.max(1, (line.size() - 1));

                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    line.set(j, line.get(j) + " ".repeat(space));
                    if (remainder > 0) {
                        line.set(j, line.get(j) + " ");
                        remainder--;
                    }
                }

                res.add(String.join("", line));
                line.clear();
                length = 0;
            }
        }

        // Handling last line
        String last_line = String.join(" ", line);
        int trail_space = maxWidth - last_line.length();
        res.add(last_line + " ".repeat(trail_space));

        return res;
    }
}