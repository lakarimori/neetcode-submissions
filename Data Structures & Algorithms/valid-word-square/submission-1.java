class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null) {
            return false;
        }

        int cols = words.size();

        for (int i=0; i<cols; i++) {
            String word = words.get(i);
            int rows = word.length();

            for (int j=0; j<rows; j++) {
                if (j >= words.size() || i >= words.get(j).length() || word.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}