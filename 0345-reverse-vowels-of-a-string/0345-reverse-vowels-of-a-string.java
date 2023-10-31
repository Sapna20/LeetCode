class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        int n = j+1;
        List<Character> ls = new ArrayList<Character> ();
        ls.addAll(Arrays.asList('a','e','i','u','o','A','E','I','U','O'));
        char[] arr = s.toCharArray();
        while(i<n && j>= 0 && i<j) {
            while(i<n && !ls.contains(s.charAt(i))) {
                i++;
            }
            while(j>=0 && !ls.contains(s.charAt(j))) {
                j--;
            }
            if(i<n && j>= 0 && i<j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
}