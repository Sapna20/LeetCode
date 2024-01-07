class Solution {
    public int gcd(int a, int b) {
        int result = Math.min(a, b);
        while(result > 0) {
            if(a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }

    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int k = gcd(n, m);
        return (str1 + str2).equals(str2 + str1) ? str1.substring(0, k) : "";
    }
}