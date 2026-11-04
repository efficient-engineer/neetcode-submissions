
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(0, s, part, res);

        return res;
    }

    private void dfs(int start, String s,
                     List<String> part,
                     List<List<String>> res) {

        if (start >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPali(s, start, end)) {

                part.add(s.substring(start, end + 1));

                dfs(end + 1, s, part, res);

                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}