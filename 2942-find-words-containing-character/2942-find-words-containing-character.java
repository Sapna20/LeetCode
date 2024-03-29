class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ls = new ArrayList<Integer> ();
        int j=0;
        for(String word : words) {
            for(int i=0; i<word.length(); i++) {
                if(word.charAt(i) == x) {
                    ls.add(j);
                    break;
                }
            }
            j++;
        }
        return ls;
    }
}