class Solution {
    public String reverseVowels(String str) {
        int i=0, j=str.length()-1;
        List<Character> ls = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] s = str.toCharArray();

        while(i<j) {
            if(!ls.contains(s[i])) {
                i++;
            }
            if(!ls.contains(s[j])) {
                j--;
            }

            if(ls.contains(s[i]) && ls.contains(s[j])) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }

        }

        return String.valueOf(s);

    }
}