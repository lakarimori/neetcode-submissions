class Solution {
    /*
    Hashmap 
    [a , 1]
    [b , 1]
    [c , 1]


    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        for (int i=0; i<=s2.length() - s1.length(); i++) {
            String copy = s1;
            int counter = i;

            while (counter < s2.length() && copy.contains(String.valueOf(s2.charAt(counter)))) {
                copy = copy.replaceFirst(String.valueOf(s2.charAt(counter)), "");
                counter++;
            }

            if (copy.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
