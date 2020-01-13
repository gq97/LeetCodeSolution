import java.util.HashMap;
import java.util.Map;

public class LeetCode290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0 || pattern == null || str == null) return false;
        String[] words = str.split(" ");
        boolean result = pattern.length() == words.length ? true : false;
        if(result) {
            Map<String, Integer> word2alpha = new HashMap<>();
            Map<Integer, String> alpha2word = new HashMap<>();
            char[] pattern_array = pattern.toCharArray();
            for(int i = 0; i < words.length; i++) {
                int id = pattern_array[i] - 'a';
                if(word2alpha.get(words[i]) == null && alpha2word.get(id) == null) {
                    word2alpha.put(words[i], id);
                    alpha2word.put(id, words[i]);
                } else if(word2alpha.get(words[i]) == null || alpha2word.get(id) == null) {
                    return false;
                } else {
                    if(word2alpha.get(words[i]) != id || !alpha2word.get(id).equals(words[i])) {
                        return false;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = " dog cat cat dog";
        LeetCode290_WordPattern solution = new LeetCode290_WordPattern();
        System.out.println(solution.wordPattern(pattern, str));
    }
}
