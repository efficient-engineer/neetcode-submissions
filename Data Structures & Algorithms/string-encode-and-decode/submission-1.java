class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String x : strs) {
            sb.append(x.length());
            sb.append("#");
            sb.append(x);
        }
        return sb.toString();
    }
    // ["Hello","World"] -> 5#Hello5#World

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < str.length()) {
            int delimiter = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiter));
            int start = delimiter + 1;
            int end = start + length;

            result.add(str.substring(start, end));

            i = end;
        }
        return result;
    }
}
