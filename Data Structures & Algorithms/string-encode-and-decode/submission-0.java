class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String x : strs) {
            sb.append(x);
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] strs = str.split(",");
        return List.of(strs);
    }
}
