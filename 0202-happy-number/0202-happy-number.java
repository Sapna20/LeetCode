class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<Integer>();

        while(n != 1) {
            int temp = n;
            n=0;
            while(temp!=0) {
                int x = temp%10;
                x *= x;
                n += x;
                temp /= 10;
            }
            if(st.contains(n))
                return false;
             st.add(n);
        }

        return true;
    }
}