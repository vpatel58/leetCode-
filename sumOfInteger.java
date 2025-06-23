class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bit = bitA ^ bitB ^ carry;
            int carryOut = (bitA & bitB) | (bitA & carry) | (bitB & carry);
            int mask = bit << i;
            sum = sum | mask; 
            carry = carryOut;
        }
        return sum;
    }
}
