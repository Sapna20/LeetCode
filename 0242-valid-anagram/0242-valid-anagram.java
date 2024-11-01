class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int n = s.length();

        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        String s_temp = String.valueOf(s_arr);
        String t_temp = String.valueOf(t_arr);

        if(s_temp.equals(t_temp)) {
            return true;
        }

        return false;
    }
}