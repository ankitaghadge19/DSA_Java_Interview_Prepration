package string.easy.longestcommonprefix;

public class Optimal1 {
    public static void main(String[] args) {
        String[] words = { "flower", "flow", "flight" };

        StringBuilder commonPrefix = new StringBuilder();

        char[] chars1 = words[0].toCharArray();
        char[] chars2 = words[1].toCharArray();
        int p1=0;
        int p2=0;

        while (p1 < chars1.length && p2 < chars2.length) {
            if (chars1[p1] == chars2[p2]) {
                commonPrefix.append(chars1[p1]);
                p1++;
                p2++;
            } else {
                break;
            }
        }

        String result = "";
        for (int i = 2; i < words.length; i++) {
            chars1 = commonPrefix.toString().toCharArray();
            chars2 = words[i].toCharArray();

            p1 = 0;
            p2 = 0;
            while (p1 < chars1.length && p2 < chars2.length) {
                if (chars1[p1] == chars2[p2]) {
                    p1++;
                    p2++;
                } else {
                    break;
                }
            }
            result = commonPrefix.toString().substring(0, p1);

            // (Early break) Eg. flower, flow, abc
            if (commonPrefix.isEmpty()) {
                break;
            }
        }
        System.out.println(result);
    }
}
