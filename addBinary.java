import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);

        BigInteger carry = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;

        int maxBits = Math.max(x.bitLength(), y.bitLength());

        for (int i = 0; i <= maxBits || carry.equals(BigInteger.ONE); i++) {
            int bitA = x.testBit(i) ? 1 : 0;
            int bitB = y.testBit(i) ? 1 : 0;

            int bitSum = bitA ^ bitB ^ carry.intValue();
            if (bitSum == 1) {
                sum = sum.setBit(i);
            }

            // Update carry
            if ((bitA + bitB + carry.intValue()) >= 2) {
                carry = BigInteger.ONE;
            } else {
                carry = BigInteger.ZERO;
            }
        }

        return sum.toString(2);
    }
}
