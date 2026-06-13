class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        while (text.contains("%")) {
            for (List<String> replacement : replacements) {
                text = text.replace("%"+replacement.get(0)+"%", replacement.get(1));
            }
        }

        return text;
    }
}
