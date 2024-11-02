class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int n = s.length();
        int res = n;

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(arr[c-'a'] == -1) {
                arr[c-'a'] = i;
            } else {
                arr[c-'a'] = n;
            }
        }

        for(int i=0; i<26; i++) {
            res = arr[i] != -1 ? Math.min(arr[i], res) : res;
        }

        return res == n ? -1 : res;

    }
}