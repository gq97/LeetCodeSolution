public class LeetCode242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] hashmap = new int[130];
        for(char ch : s.toCharArray()) {
            hashmap[ch]++;
        }
        for(char ch : t.toCharArray()) {
            if(hashmap[ch] == 0) return false;
            hashmap[ch]--;
        }
        return true;
    }
}
