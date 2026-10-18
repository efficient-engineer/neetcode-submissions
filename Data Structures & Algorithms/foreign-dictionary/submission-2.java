class Solution {
    public String foreignDictionary(String[] words) {
      Set<Character> chars = new HashSet<>();
      for(String word : words) {
        for(char c : word.toCharArray()) {
            chars.add(c);
        }
      }

      int n = chars.size();
      Map<Character, List<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegrees = new HashMap<>();

      for(char c : chars) {
        graph.put(c, new ArrayList<Character>());
        indegrees.put(c, 0);
      }

      for(int i = 0; i < words.length - 1; i++) {
        String first = words[i];
        String second = words[i + 1];

        boolean diff = false;
        int minLength = Math.min(first.length(), second.length());
        for(int index = 0; index < minLength; index++) {
            char a = first.charAt(index);
            char b = second.charAt(index);
            if(a != b) {
                diff = true;
                graph.get(a).add(b);
                indegrees.put(b, indegrees.getOrDefault(b, 0) + 1);
                break;
            }
        }

        if(!diff && first.length() > second.length()) return "";
      }

      Queue<Character> queue = new LinkedList<>();

      for(char c : chars) {
        if(indegrees.get(c) == 0) queue.offer(c);
      }
      
      StringBuilder sb = new StringBuilder();
      while(!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);
        for(char next : graph.get(c)) {
            indegrees.put(next, indegrees.get(next) - 1);
            if(indegrees.get(next) == 0) queue.offer(next);
        }
      }
      for(char curr : chars) {
        if(indegrees.get(curr) != 0) return "";
      }
      return sb.toString();
    }
}
