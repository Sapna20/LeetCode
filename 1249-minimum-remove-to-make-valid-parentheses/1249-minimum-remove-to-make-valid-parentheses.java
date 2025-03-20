class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        List<Integer> removeIdx = new ArrayList<Integer>();

        for(int i = 0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || c == '(') {
                st.push(new Pair(c, i));
            } else {
                while(!st.isEmpty() && !(st.peek().getKey() == '(')) {
                    st.pop();
                }
                if(st.isEmpty()) 
                    removeIdx.add(i);
                else if(st.peek().getKey() == '(')
                    st.pop();
            }
        }
        while(!st.isEmpty()) {
            Character c = st.peek().getKey();
            if(c == '(' || c == ')')
                removeIdx.add(st.peek().getValue());
            st.pop();
        }
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            if(!removeIdx.contains(i))
                ans += s.charAt(i);
        }
        return ans;
    }
}