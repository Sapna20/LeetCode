class Solution {
    public int maxVowels(String s, int k) {
        int i=0, j=0, currN=0, maxN=0;
        List<Character> ls = new ArrayList<Character>();
        ls.add('a');
        ls.add('e');
        ls.add('i');
        ls.add('o');
        ls.add('u');

        while(j<k) {
            if(ls.contains(s.charAt(j))) {
                maxN++;
                currN++;
            }
            j++;
        }
        while(j<s.length()) {
            if(ls.contains(s.charAt(i))) {
                currN--;
            }
            i++;
            if(ls.contains(s.charAt(j))) {
                currN++;
            }
            j++;
            maxN = Math.max(maxN, currN);
        }

        return maxN;
    }
}