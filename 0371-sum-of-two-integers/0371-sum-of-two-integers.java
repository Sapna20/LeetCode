class Solution {

    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        
        for(int i=0; i<32; i++){
            int temp1 = a & 1;
            int temp2 = b & 1;

            int curr = (temp1 ^ temp2 ^ carry);
            sum = sum | (curr << i);

            a = a >> 1;
            b = b >> 1;

            carry = (temp1 & temp2) | (temp1 & carry) | (temp2 & carry);
        }

        return sum;
    }
}
