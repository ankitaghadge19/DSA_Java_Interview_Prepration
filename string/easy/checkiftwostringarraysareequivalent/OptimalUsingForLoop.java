package string.easy.checkiftwostringarraysareequivalent;

public class OptimalUsingForLoop {
    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };

        StringBuilder combineWord1 = new StringBuilder();
        for (String word : word1) {
            combineWord1.append(word);
        }

        StringBuilder combineWord2 = new StringBuilder();
        for (String word : word2) {
            combineWord2.append(word);
        }

        System.out.println(combineWord1.toString().equals(combineWord2.toString()));
    }
}

// TC: O(N + M)
// SC: O(N + M)